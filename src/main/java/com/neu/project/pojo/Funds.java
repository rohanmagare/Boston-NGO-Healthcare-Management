package com.neu.project.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funds")
public class Funds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3447822698496565601L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fundId")
	private Long fundId;

	@Column(name = "totalFunds")
	private Long totalFunds;

	public Long getFundId() {
		return fundId;
	}

	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}

	public Long getTotalFunds() {
		return totalFunds;
	}

	public void setTotalFunds(Long totalFunds) {
		this.totalFunds = totalFunds;
	}

}
