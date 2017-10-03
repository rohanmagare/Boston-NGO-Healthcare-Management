package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Funds;

public class FundsDAO extends DAO {

	public FundsDAO() {

	}

	public List<Funds> getFunds() throws UserException {
		try {
			begin();
			String hql = "FROM Funds";
			Query query = getSession().createQuery(hql);
			List<Funds> funds = (List<Funds>) query.list();
			commit();
			return funds;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get funds", e);
		}
	}

	public Funds getLastFundRecord() throws UserException {

		try {
			begin();
			String hql = "FROM Funds ORDER BY fundId DESC";
			Funds funds = (Funds) getSession().createQuery(hql).setMaxResults(1).uniqueResult();
			commit();
			return funds;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get last fund record", e);
		}
	}

	public void addNewFundsRecord(Long addFunds) throws UserException {

		try {
			begin();
			System.out.println("inside DAO");
			Funds fundsNew = new Funds();
			fundsNew.setTotalFunds(addFunds);
			getSession().save(fundsNew);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not save fund record", e);
		}
	}

}
