package com.neu.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.EmployeeDAO;
import com.neu.project.dao.FundsDAO;
import com.neu.project.dao.ProjectDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.dao.VolunteerDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.Employee;
import com.neu.project.pojo.Funds;
import com.neu.project.pojo.Project;
import com.neu.project.pojo.User;
import com.neu.project.pojo.Volunteer;

@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("projectDao")
	ProjectDAO projectDao;

	@Autowired
	@Qualifier("fundsDao")
	FundsDAO fundsDao;

	@Autowired
	@Qualifier("volunteerDao")
	VolunteerDAO volunteerDao;

	@Autowired
	@Qualifier("employeeDao")
	EmployeeDAO employeeDao;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/employeelogin.htm", method = RequestMethod.POST)
	protected ModelAndView showProjectDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("employee") Employee employee, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return new ModelAndView("employee-login", "employee", employee);
		}
		try {
			Funds funds = fundsDao.getLastFundRecord();
			request.getSession().setAttribute("funds", funds);
			System.out.print("project details");
			return new ModelAndView("employee-project", "project", employee.getProject());

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while getting funds");
		}

	}

	@RequestMapping(value = "/employeeproject.htm", method = RequestMethod.POST)
	protected ModelAndView updateProjectDetails(HttpServletRequest request) throws Exception {

		try {

			System.out.print("registerNewUser");
			String addFunds = request.getParameter("addFunds");
			Funds funds = (Funds) request.getSession().getAttribute("funds");
			Project project = (Project) request.getSession().getAttribute("project");
			project.setProjectAim(request.getParameter("aim"));
			project.setProjectDescription(request.getParameter("desc"));

			if (!addFunds.isEmpty()) {
				project.setFundsAllocated(project.getFundsAllocated() + Long.parseLong(addFunds));
			}
			Project updatedProject = projectDao.updateProject(project);

			if (!addFunds.isEmpty()) {
				Funds fundsLast = fundsDao.getLastFundRecord();
				Long amount = fundsLast.getTotalFunds() - Long.parseLong(addFunds);
				fundsDao.addNewFundsRecord(amount);
			}

			User u = (User) request.getSession().getAttribute("user");
			Employee employee = employeeDao.getEmployeeByUserId(u);
			List<Volunteer> volunteers = volunteerDao.getUnassignedVolunteers();
			request.getSession().setAttribute("unvolunteers", volunteers);
			request.getSession().setAttribute("employee", employee);
			request.getSession().setAttribute("project", employee.getProject());
			return new ModelAndView("employee-login");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating ");
		}

	}

	@RequestMapping(value = "/employeevolunteer.htm", method = RequestMethod.GET)
	protected ModelAndView assignProjectToVolunteer(HttpServletRequest request) throws Exception {

		try {

			System.out.println("assignProjectToVolunteer");
			String vId = request.getParameter("vId");

			Volunteer volunteer = volunteerDao.getVolunteerByVolunteerId(Long.parseLong(vId));

			if (volunteer != null) {
				Employee employee = (Employee) request.getSession().getAttribute("employee");
				if (employee != null) {
					volunteer.setIsAssignedToAProject("Yes");
					volunteer.setIsAvailable("No");
					if (employee.getProject() != null) {
						volunteer.setProject(employee.getProject());
						volunteerDao.updateVolunteer(volunteer);
						User volunteerUser = userDao.get(volunteer.getVolunteerId());
						User user = (User) request.getSession().getAttribute("user");
						String emailAddress = user.getEmail().getEmailAddress();
						String senderAddress = emailAddress;
						String recipientAddress = volunteerUser.getEmail().getEmailAddress();
						String subject = "Regarding assignment of" + employee.getProject().getProjectName();
						String message = "This is to notify to you that you are being assigned to the project"
								+ employee.getProject().getProjectName() + ". You will get further details later.";

						// prints debug info
						System.out.println("To: " + recipientAddress);
						System.out.println("Subject: " + subject);
						System.out.println("Message: " + message);

						// creates a simple e-mail object
						SimpleMailMessage email = new SimpleMailMessage();
						email.setFrom(senderAddress);
						email.setTo(recipientAddress);
						email.setSubject(subject);
						email.setText(message);

						// sends the e-mail
						mailSender.send(email);
					}
				}
			}

			List<Volunteer> volunteers = volunteerDao.getUnassignedVolunteers();
			request.getSession().setAttribute("unvolunteers", volunteers);

			return new ModelAndView("employee-login");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating ");
		}

	}

}
