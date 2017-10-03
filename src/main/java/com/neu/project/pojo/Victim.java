package com.neu.project.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "victim")
public class Victim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1089409197345799721L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "victimId", unique = true, nullable = false)
	private Long victimId;

	@Column(name = "victimName")
	private String victimName;

	@Column(name = "victimAge")
	private Long victimAge;

	@Column(name = "category")
	private String category;

	@ManyToMany(mappedBy = "victims")
	Set<Project> projects = new HashSet<Project>();

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getVictimId() {
		return victimId;
	}

	public void setVictimId(Long victimId) {
		this.victimId = victimId;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public Long getVictimAge() {
		return victimAge;
	}

	public void setVictimAge(Long victimAge) {
		this.victimAge = victimAge;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
