package com.neu.project.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "donor")
public class Donor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6875030407594397382L;
	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = {
			@Parameter(value = "user", name = "property") })
	private Long donorId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donorId")
	User user = new User();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "donor")
	private Set<Donation> donations = new HashSet<Donation>(0);

	@Column(name = "isLegalAge")
	private String isLegalAge;

	@Column(name = "ssn", nullable = false, unique = true)
	private String ssn;

	@Column(name = "isSelfEmployed", nullable = false)
	private String isSelfEmployed;

	@Column(name = "companyName", nullable = false)
	private String companyName;

	public String getIsLegalAge() {
		return isLegalAge;
	}

	public void setIsLegalAge(String isLegalAge) {
		this.isLegalAge = isLegalAge;
	}

	public String getIsSelfEmployed() {
		return isSelfEmployed;
	}

	public void setIsSelfEmployed(String isSelfEmployed) {
		this.isSelfEmployed = isSelfEmployed;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
