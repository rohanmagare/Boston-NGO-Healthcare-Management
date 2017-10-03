package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Volunteer;

public class VolunteerDAO extends DAO {

	public VolunteerDAO() {

	}

	public void register(Volunteer v) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Volunteer volunteer = new Volunteer();
			volunteer.setIsAssignedToAProject("No");
			volunteer.setIsLegalAge(v.getIsLegalAge());
			volunteer.setIsAvailable(v.getIsAvailable());
			volunteer.setIsRequested("No");
			volunteer.setSsn(v.getSsn());
			volunteer.setUser(v.getUser());
			getSession().save(volunteer);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public List<Volunteer> getUnassignedVolunteers() throws UserException {

		try {
			begin();
			String hql = "FROM Volunteer where isAssignedToAProject = :isAssignedToAProject and isLegalAge = :isLegalAge and isAvailable = :isAvailable";
			Query query = getSession().createQuery(hql);
			query.setString("isAssignedToAProject", "No");
			query.setString("isLegalAge", "Yes");
			query.setString("isAvailable", "Yes");
			List<Volunteer> volunteers = (List<Volunteer>) query.list();
			commit();
			return volunteers;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get projects", e);
		}
	}

	public Volunteer getVolunteerByVolunteerId(Long vId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Volunteer where volunteerId = :volunteerId");
			q.setLong("volunteerId", vId);
			Volunteer volunteer = (Volunteer) q.uniqueResult();
			commit();
			return volunteer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get volunteer volunteerdao " + vId, e);
		}
	}

	public void updateVolunteer(Volunteer volunteer) throws UserException {
		try {
			begin();
			System.out.println("inside volunteer DAO");

			getSession().merge(volunteer);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating volunteer volunteerdao: " + e.getMessage());
		}
	}

}
