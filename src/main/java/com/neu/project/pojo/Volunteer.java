package com.neu.project.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "volunteer")
public class Volunteer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5982965583590944517L;
	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = {
			@Parameter(value = "user", name = "property") })
	private Long volunteerId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "volunteerId")
	User user = new User();

	@ManyToOne(cascade = CascadeType.ALL)
	private Project project;

	@Column(name = "isLegalAge")
	private String isLegalAge;

	@Column(name = "isAssignedToAProject")
	private String isAssignedToAProject;

	@Column(name = "isAvailable")
	private String isAvailable;

	@Column(name = "isRequested")
	private String isRequested;

	@Column(name = "ssn", nullable = true, unique = true)
	private String ssn;

	public String getIsRequested() {
		return isRequested;
	}

	public void setIsRequested(String isRequested) {
		this.isRequested = isRequested;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsAssignedToAProject() {
		return isAssignedToAProject;
	}

	public void setIsAssignedToAProject(String isAssignedToAProject) {
		this.isAssignedToAProject = isAssignedToAProject;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getIsLegalAge() {
		return isLegalAge;
	}

	public void setIsLegalAge(String isLegalAge) {
		this.isLegalAge = isLegalAge;
	}

	public Long getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(Long volunteerId) {
		this.volunteerId = volunteerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
