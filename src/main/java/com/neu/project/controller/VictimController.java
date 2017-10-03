package com.neu.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.EmployeeDAO;
import com.neu.project.dao.ProjectDAO;
import com.neu.project.dao.VictimDAO;
import com.neu.project.dao.VolunteerDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.Employee;
import com.neu.project.pojo.Project;
import com.neu.project.pojo.User;
import com.neu.project.pojo.Victim;
import com.neu.project.pojo.Volunteer;

@Controller
public class VictimController {

	@Autowired
	@Qualifier("projectDao")
	ProjectDAO projectDao;

	@Autowired
	@Qualifier("victimDao")
	VictimDAO victimDao;

	@Autowired
	@Qualifier("employeeDao")
	EmployeeDAO employeeDao;

	@Autowired
	@Qualifier("volunteerDao")
	VolunteerDAO volunteerDao;

	@RequestMapping(value = "/addvictim.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("addvictim");

		return new ModelAndView("add-victim", "victim", new Victim());
	}

	@RequestMapping(value = "/registervictim.htm", method = RequestMethod.POST)
	protected ModelAndView registerEmployee(HttpServletRequest request, @ModelAttribute("victim") Victim victim,
			BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return new ModelAndView("add-victim", "victim", victim);
		}

		try {
			System.out.print("adding victim");
			List<Victim> victims = victimDao.getAllVictims();
			if (victim.getCategory().equalsIgnoreCase("1")) {
				if (victims.isEmpty() || victims == null) {
					victims = new ArrayList<Victim>();
				}
				Project project1 = projectDao.getProject(Long.parseLong("1"));
				victims.add(victim);
				project1.setVictims(victims);
				projectDao.saveProject(project1);
			} else if (victim.getCategory().equalsIgnoreCase("2")) {
				if (victims.isEmpty() || victims == null) {
					victims = new ArrayList<Victim>();
				}
				Project project1 = projectDao.getProject(Long.parseLong("2"));
				victims.add(victim);
				project1.setVictims(victims);
				projectDao.saveProject(project1);
			} else if (victim.getCategory().equalsIgnoreCase("3")) {
				if (victims.isEmpty() || victims == null) {
					victims = new ArrayList<Victim>();
				}
				Project project1 = projectDao.getProject(Long.parseLong("3"));
				victims.add(victim);
				project1.setVictims(victims);
				projectDao.saveProject(project1);
			}
			User u = (User) request.getSession().getAttribute("user");
			Employee employee = employeeDao.getEmployeeByUserId(u);
			List<Volunteer> volunteers = volunteerDao.getUnassignedVolunteers();
			request.getSession().setAttribute("unvolunteers", volunteers);
			request.getSession().setAttribute("employee", employee);
			Project project = employee.getProject();
			request.getSession().setAttribute("project", employee.getProject());
			request.getSession().setAttribute("victims", project.getVictims());
			return new ModelAndView("employee-login");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding victim");
		}
	}
}
