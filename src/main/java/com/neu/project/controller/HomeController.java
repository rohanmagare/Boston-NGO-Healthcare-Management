package com.neu.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.DonorDAO;
import com.neu.project.dao.EmployeeDAO;
import com.neu.project.dao.ProjectDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.dao.VolunteerDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.Donation;
import com.neu.project.pojo.Donor;
import com.neu.project.pojo.Employee;
import com.neu.project.pojo.Project;
import com.neu.project.pojo.User;
import com.neu.project.pojo.Volunteer;
import com.neu.project.validator.DonorValidator;
import com.neu.project.validator.EmployeeValidator;
import com.neu.project.validator.UserValidator;
import com.neu.project.validator.VolunteerValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;

	@InitBinder("userValidator")
	private void initUserBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@Autowired
	@Qualifier("employeeValidator")
	EmployeeValidator employeeValidator;

	@InitBinder("employeeValidator")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}

	@Autowired
	@Qualifier("donorValidator")
	DonorValidator donorValidator;

	@InitBinder("donorValidator")
	private void initDonorBinder(WebDataBinder binder) {
		binder.setValidator(donorValidator);
	}

	@Autowired
	@Qualifier("volunteerValidator")
	VolunteerValidator volunteerValidator;

	@InitBinder("volunteerValidator")
	private void initVolunteerBinder(WebDataBinder binder) {
		binder.setValidator(volunteerValidator);
	}

	@Autowired
	ServletContext servletContext;

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("projectDao")
	ProjectDAO projectDao;

	@Autowired
	@Qualifier("employeeDao")
	EmployeeDAO employeeDao;

	@Autowired
	@Qualifier("volunteerDao")
	VolunteerDAO volunteerDao;

	@Autowired
	@Qualifier("donorDao")
	DonorDAO donorDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws UserException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws UserException {

		// User user1 = new User();
		// user1.setAddress("aaa");
		// user1.setPhoneNumber("1234567890");
		// user1.setFirstName("fdhsgf");
		// user1.setLastName("sdgfh");
		// user1.setPassword("djfhd");
		// user1.setRole("Employee");
		// user1.setUserName("sdgf");
		//
		// User user2 = new User();
		// user2.setAddress("aaa");
		// user2.setPhoneNumber("1234567890");
		// user2.setFirstName("fdhsgf");
		// user2.setLastName("sdgfh");
		// user2.setPassword("djfhd");
		// user2.setRole("Donor");
		// user2.setUserName("sdjfdh");
		//
		// User user3 = new User();
		// user3.setAddress("aaa");
		// user3.setPhoneNumber("1234567890");
		// user3.setFirstName("fdhsgf");
		// user3.setLastName("sdgfh");
		// user3.setPassword("djfhd");
		// user3.setRole("Volunteer");
		// user3.setUserName("sdgfsdfh");
		//
		//
		// Set<Employee> employees = new HashSet<Employee>();
		// Employee emp = new Employee();
		// emp.setBonus(347L);
		// emp.setEmploymentType("Contract");
		// emp.setSalary(32478L);
		// emp.setSsn("3246");
		// emp.setUser(user1);
		// employees.add(emp);
		//
		// Set<Volunteer> volunteers = new HashSet<Volunteer>();
		// Volunteer volunteer = new Volunteer();
		// volunteer.setLegalAge(true);
		// volunteer.setSsn("384789");
		// volunteer.setUser(user3);
		// volunteers.add(volunteer);
		//
		//
		//
		// Donor donor = new Donor();
		// donor.setCompanyName("shdgfj");
		// donor.setLegalAge(true);
		// donor.setSelfEmployed(false);
		// donor.setSsn("ssydgfj");
		// donor.setUser(user2);
		//// donor.setDonations(donations);
		//
		// Donation donation = new Donation();
		// donation.setAmount(3274L);
		// donation.setDonor(donor);

		// Project project1 = new Project();
		// project1.setFundsAllocated(346L);
		// project1.setProjectAim("sjdgf");
		// project1.setProjectDescription("skjhdfjks");
		// project1.setProjectName("rohan");
		// project1 = projectDao.saveProject(project1);
		//
		// Project project2 = new Project();
		// project2.setFundsAllocated(346L);
		// project2.setProjectAim("sdjfkkjsd");
		// project2.setProjectDescription("skjjhdagjshdfjks");
		// project2.setProjectName("prashant");
		// project2 = projectDao.saveProject(project2);
		//
		// Project project3 = new Project();
		// project3.setFundsAllocated(346L);
		// project3.setProjectAim("shdgfshhf");
		// project3.setProjectDescription("kjyiuayhdsa");
		// project3.setProjectName("karan");
		// project3 = projectDao.saveProject(project3);

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.getSession().invalidate();
		}

		/*
		 * Project proj = projectDao.getProject("rohan"); Volunteer vol =
		 * volunteerDao.getVolunteerByVolunteerId(5L);
		 * vol.setIsAssignedToAProject("Yes"); vol.setIsAvailable("No");
		 * vol.setProject(proj); volunteerDao.updateVolunteer(vol);
		 */
		return "home";

	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			System.out.print("loginUser");
			User u = userDao.get(request.getParameter("username"), request.getParameter("password"));

			if (u == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}

			session.setAttribute("user", u);
			if (u.getRole().equalsIgnoreCase("employee")) {

				Employee employee = employeeDao.getEmployeeByUserId(u);
				List<Volunteer> volunteers = volunteerDao.getUnassignedVolunteers();
				request.getSession().setAttribute("unvolunteers", volunteers);
				request.getSession().setAttribute("employee", employee);
				Project project = employee.getProject();
				request.getSession().setAttribute("project", employee.getProject());
				request.getSession().setAttribute("victims", project.getVictims());
				return new ModelAndView("employee-login");
			} else if (u.getRole().equalsIgnoreCase("donor")) {
				Donor donor = donorDao.getDonorByUserId(u);
				Set<Donation> donations = (Set<Donation>) donor.getDonations();
				if ((!donations.isEmpty()) & donations != null) {
					request.getSession().setAttribute("donations", donations);
				}
				request.getSession().setAttribute("donor", donor);
				return new ModelAndView("donor-details");
			} else if (u.getRole().equalsIgnoreCase("volunteer")) {
				Volunteer volunteer = volunteerDao.getVolunteerByVolunteerId(u.getUserId());
				request.getSession().setAttribute("volunteer", volunteer);
				if (volunteer.getIsAssignedToAProject().equalsIgnoreCase("yes")) {

					Project project = volunteer.getProject();
					request.getSession().setAttribute("project", project);
					return new ModelAndView("volunteer-details");

				} else if (volunteer.getIsAssignedToAProject().equalsIgnoreCase("no")) {

					List<Project> projects = projectDao.getProjects();
					request.getSession().setAttribute("projects", projects);
					return new ModelAndView("volunteer-request");
				}
			}

			return new ModelAndView("home");

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("registerUser");

		return new ModelAndView("user-register", "user", new User());

	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("user") User user,
			BindingResult result) throws Exception {

		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("user-register", "user", user);
		}
		try {

			System.out.print("registerNewUser");
			CommonsMultipartFile photoInMemory = user.getPhoto();
			String fileName = photoInMemory.getOriginalFilename();
			String baseName = "E:/photos/";
			File userFile = new File(baseName + user.getEmail().getEmailId());
			String currentTime = String.valueOf(System.currentTimeMillis());
			if (!userFile.exists()) {
				if (userFile.mkdir()) {
					File eventFile = new File(userFile + "/" + currentTime);
					eventFile.mkdir();
					user.setFilename(eventFile.getPath());
				}
			} else {
				File eventFile = new File(userFile + "/" + currentTime);
				if (!eventFile.exists()) {
					if (eventFile.mkdir()) {
						user.setFilename(eventFile.getPath());
						user.setFilename(eventFile.getPath());
					}
				}
			}
			File localFile = new File(baseName + user.getEmail().getEmailId() + "/" + currentTime + "/", fileName);
			photoInMemory.transferTo(localFile);
			user.setFilename(localFile.getPath());
			User u = userDao.register(user);
			request.getSession().setAttribute("user", u);
			if (u.getRole().equalsIgnoreCase("employee")) {
				return new ModelAndView("employee-registration", "employee", new Employee());
			} else if (u.getRole().equalsIgnoreCase("volunteer")) {
				return new ModelAndView("volunteer-registration", "volunteer", new Volunteer());
			} else if (u.getRole().equalsIgnoreCase("donor")) {
				return new ModelAndView("donor-registration", "donor", new Donor());
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/employeeRegister.htm", method = RequestMethod.POST)
	protected ModelAndView registerEmployee(HttpServletRequest request, @ModelAttribute("employee") Employee employee,
			BindingResult result) throws Exception {

		employeeValidator.validate(employee, result);

		if (result.hasErrors()) {
			return new ModelAndView("employee-registration", "employee", employee);
		}

		try {
			System.out.print("registerNewUser");
			String project = request.getParameter("task");
			User u = (User) request.getSession().getAttribute("user");
			Project p = (Project) projectDao.getProject(Long.parseLong(project));
			employee.setProject(p);
			employee.setUser(u);
			employeeDao.register(employee);
			return new ModelAndView("home");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

	@RequestMapping(value = "/volunteerRegister.htm", method = RequestMethod.POST)
	protected ModelAndView registerVolunteer(HttpServletRequest request,
			@ModelAttribute("volunteer") Volunteer volunteer, BindingResult result) throws Exception {

		volunteerValidator.validate(volunteer, result);

		if (result.hasErrors()) {
			return new ModelAndView("volunteer-registration", "volunteer", volunteer);
		}

		try {

			System.out.print("registerNewUser");
			User u = (User) request.getSession().getAttribute("user");
			volunteer.setUser(u);
			volunteerDao.register(volunteer);
			return new ModelAndView("home");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

	@RequestMapping(value = "/donorRegister.htm", method = RequestMethod.POST)
	protected ModelAndView registerdonor(HttpServletRequest request, @ModelAttribute("donor") Donor donor,
			BindingResult result) throws Exception {

		donorValidator.validate(donor, result);

		if (result.hasErrors()) {
			return new ModelAndView("donor-registration", "donor", donor);
		}

		try {

			System.out.print("registerNewUser");
			User u = (User) request.getSession().getAttribute("user");
			donor.setUser(u);
			donorDao.register(donor);
			return new ModelAndView("home");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

}
