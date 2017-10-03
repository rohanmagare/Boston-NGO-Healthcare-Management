package com.neu.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rohan
 *
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8840859690578385365L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "projectId")
	private Long projectId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private Set<Employee> employees = new HashSet<Employee>(0);

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private Set<Volunteer> volunteers = new HashSet<Volunteer>(0);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "project_victim", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "victimId"))
	private List<Victim> victims = new ArrayList<Victim>();

	@Column(name = "projectName", nullable = false, unique = true)
	private String projectName;

	@Column(name = "projectDesc")
	private String projectDescription;

	@Column(name = "projectAim")
	private String projectAim;

	@Column(name = "fundsAllocated")
	private Long fundsAllocated;

	public List<Victim> getVictims() {
		return victims;
	}

	public void setVictims(List<Victim> victims) {
		this.victims = victims;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(Set<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectAim() {
		return projectAim;
	}

	public void setProjectAim(String projectAim) {
		this.projectAim = projectAim;
	}

	public Long getFundsAllocated() {
		return fundsAllocated;
	}

	public void setFundsAllocated(Long fundsAllocated) {
		this.fundsAllocated = fundsAllocated;
	}

}
