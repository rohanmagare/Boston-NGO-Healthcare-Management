package com.neu.project.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Project;
import com.neu.project.pojo.Victim;

public class VictimDAO extends DAO {

	public VictimDAO() {
	}

	public void registerVictim(Victim v) throws UserException {
		try {
			begin();
			System.out.println("inside victim DAO");
			getSession().save(v);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating victim: " + e.getMessage());
		}
	}

	public List<Victim> getAllVictims() throws UserException {
		try {
			begin();
			String hql = "FROM Victim";
			Query query = getSession().createQuery(hql);
			List<Victim> victims = (List<Victim>) query.list();
			commit();
			return victims;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get projects", e);
		}
	}
}
