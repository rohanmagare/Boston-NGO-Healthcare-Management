package com.neu.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.CascadeType;

@Entity
@Table(name = "donation")
public class Donation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -386829544252023345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "donationId")
	private Long donationId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Donor donor;

	@Column(name = "amount")
	private Long amount;

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getDonationId() {
		return donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

}
