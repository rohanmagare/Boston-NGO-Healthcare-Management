package com.neu.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.DonationDAO;
import com.neu.project.dao.DonorDAO;
import com.neu.project.dao.FundsDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.Donation;
import com.neu.project.pojo.Donor;
import com.neu.project.pojo.Funds;

@Controller
public class DonorController {

	@Autowired
	@Qualifier("donorDao")
	DonorDAO donorDao;

	@Autowired
	@Qualifier("donationDao")
	DonationDAO donationDao;

	@Autowired
	@Qualifier("fundsDao")
	FundsDAO fundsDao;

	@RequestMapping(value = "/donorDetails.htm", method = RequestMethod.POST)
	protected ModelAndView showDonorDetails(HttpServletRequest request) throws Exception {

		try {

			Long donationAmount = 0L;
			Donor donor = (Donor) request.getSession().getAttribute("donor");
			donor.setCompanyName(request.getParameter("company"));
			donor.setIsSelfEmployed(request.getParameter("isSelfEmployed"));
			Set<Donation> donations = new HashSet<Donation>();
			Donation donation = new Donation();
			donation.setAmount(Long.parseLong(request.getParameter("donate")));
			donation.setDonor(donor);
			donations.add(donation);
			donor.setDonations(donations);
			donorDao.updateDonor(donor);
			request.getSession().setAttribute("donor", donor);
			;
			Funds funds = fundsDao.getLastFundRecord();
			if (funds != null) {
				donationAmount = funds.getTotalFunds();
			}
			Long amount = Long.parseLong(request.getParameter("donate")) + donationAmount;
			fundsDao.addNewFundsRecord(amount);
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while getting funds");
		}
		Donor donor = (Donor) request.getSession().getAttribute("donor");
		;
		List<Donation> donations = donationDao.getDonationsByDonorId(donor);
		if ((!donations.isEmpty()) & donations != null) {
			request.getSession().setAttribute("donations", donations);
		}
		request.getSession().setAttribute("donor", donor);

		return new ModelAndView("donor-details");

	}

}
