package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Donation;
import com.neu.project.pojo.Donor;

public class DonationDAO extends DAO {

	public void addDonation(Donor donor, String amount) throws UserException {

		try {
			begin();
			System.out.println("inside donation DAO");
			Donation donation = new Donation();
			donation.setAmount(Long.parseLong(amount));
			donation.setDonor(donor);
			getSession().save(donation);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating donation: " + e.getMessage());
		}
	}

	public List<Donation> getDonationsByDonorId(Donor donor) throws UserException {

		try {
			begin();
			Query q = getSession().createQuery("from Donation where donor = :donor");
			q.setEntity("donor", donor);
			List<Donation> donations = (List<Donation>) q.list();
			commit();
			return donations;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get donor " + donor.getCompanyName(), e);
		}

	}

}
