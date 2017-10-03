package com.neu.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Donor;
import com.neu.project.pojo.User;

public class DonorDAO extends DAO {

	public DonorDAO() {

	}

	public void register(Donor d) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Donor donor = new Donor();
			donor.setCompanyName(d.getCompanyName());
			donor.setIsLegalAge(d.getIsLegalAge());
			donor.setIsSelfEmployed(d.getIsSelfEmployed());
			donor.setSsn(d.getSsn());
			donor.setUser(d.getUser());
			getSession().save(donor);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public Donor getDonorByUserId(User u) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Donor where donorId = :donorId");
			q.setLong("donorId", u.getUserId());
			Donor donor = (Donor) q.uniqueResult();
			commit();
			return donor;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get donor " + u.getFirstName(), e);
		}

	}

	public void updateDonor(Donor donor) throws UserException {

		try {
			begin();
			System.out.println("inside donor DAO");

			getSession().merge(donor);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating donor donorDAO: " + e.getMessage());
		}
	}

}
