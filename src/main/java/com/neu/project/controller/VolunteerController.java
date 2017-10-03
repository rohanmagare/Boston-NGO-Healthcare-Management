package com.neu.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.ProjectDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.dao.VolunteerDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.Project;
import com.neu.project.pojo.User;
import com.neu.project.pojo.Volunteer;

@Controller
public class VolunteerController {

	@Autowired
	@Qualifier("volunteerDao")
	VolunteerDAO volunteerDao;

	@Autowired
	@Qualifier("projectDao")
	ProjectDAO projectDao;

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/volunteerDetails.htm", method = RequestMethod.POST)
	protected ModelAndView registerEmployee(HttpServletRequest request) throws Exception {

		try {

			System.out.print("volunteer details");
			String check = request.getParameter("optradio");
			String available = request.getParameter("avail");
			if (check.equalsIgnoreCase("yes") && available.equalsIgnoreCase("yes")) {
				Volunteer volunteer = (Volunteer) request.getSession().getAttribute("volunteer");
				volunteer.setIsAssignedToAProject("no");
				volunteer.setIsAvailable("Yes");
				volunteer.setProject(null);
				volunteerDao.updateVolunteer(volunteer);
				User user = (User) request.getSession().getAttribute("user");
				String emailAddress = user.getEmail().getEmailAddress();
				String senderAddress = emailAddress;
				String subject = "Regarding project assignment";
				String message = "This is to notify to that I am want to look for other projects to work.";
				List<User> users = userDao.getUsersByRole("employee");
				String recipientAddress = users.get(0).getEmail().getEmailAddress();
				// creates a simple e-mail object
				SimpleMailMessage email = new SimpleMailMessage();
				email.setTo(senderAddress);
				email.setTo(recipientAddress);
				email.setSubject(subject);
				email.setText(message);
				// sends the e-mail
				mailSender.send(email);
				List<Project> projects = projectDao.getProjects();
				request.getSession().setAttribute("projects", projects);
				return new ModelAndView("volunteer-request");
			} else if (check.equalsIgnoreCase("yes") && available.equalsIgnoreCase("no")) {
				Volunteer volunteer = (Volunteer) request.getSession().getAttribute("volunteer");
				volunteer.setIsAssignedToAProject("no");
				volunteer.setIsAvailable("no");
				volunteer.setProject(null);
				volunteerDao.updateVolunteer(volunteer);
				User user = (User) request.getSession().getAttribute("user");
				String emailAddress = user.getEmail().getEmailAddress();
				String senderAddress = emailAddress;
				String subject = "Regarding assignment of project";
				String message = "This is to notify to that I am will not be available until further notice.";
				List<User> users = userDao.getUsersByRole("employee");
				String recipientAddress = users.get(0).getEmail().getEmailAddress();
				// creates a simple e-mail object
				SimpleMailMessage email = new SimpleMailMessage();
				email.setFrom(senderAddress);
				email.setTo(recipientAddress);
				email.setSubject(subject);
				email.setText(message);
				// sends the e-mail
				mailSender.send(email);
				return new ModelAndView("volunteer-unassigned");
			}

			return new ModelAndView("home");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

	@RequestMapping(value = "/volunteerProjectRequest.htm", method = RequestMethod.GET)
	protected ModelAndView volunteerProjectRequest(HttpServletRequest request) throws Exception {

		try {

			System.out.print("volunteer volunteerProjectRequest");
			String projectName = request.getParameter("proId");
			User volUser = (User) request.getSession().getAttribute("user");
			String emailAddress = volUser.getEmail().getEmailAddress();
			String senderAddress = emailAddress;
			String subject = "Regarding assignment of" + projectName;
			String message = "This is to notify to that I wanted to request you to assign me to the project"
					+ projectName;
			List<User> users = userDao.getUsersByRole("employee");
			String recipientAddress = users.get(0).getEmail().getEmailAddress();
			// creates a simple e-mail object
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom(senderAddress);
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText(message);
			// sends the e-mail
			mailSender.send(email);

			List<Project> projects = projectDao.getProjects();
			request.getSession().setAttribute("projects", projects);
			return new ModelAndView("volunteer-request");
		} finally {

		}
		/*
		 * catch (UserException e) { System.out.println("Exception: " +
		 * e.getMessage()); return new ModelAndView("error", "errorMessage",
		 * "error while login"); }
		 */
	}

	@RequestMapping(value = "/volunteerunassigned.htm", method = RequestMethod.GET)
	protected ModelAndView volunteerUnassigned(HttpServletRequest request) throws Exception {

		try {
			List<Project> projects = projectDao.getProjects();
			request.getSession().setAttribute("projects", projects);
			return new ModelAndView("volunteer-request");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

}
