package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Project;

public class ProjectDAO extends DAO {

	public ProjectDAO() {

	}

	public List<Project> getProjects() throws UserException {
		try {
			begin();
			String hql = "FROM Project";
			Query query = getSession().createQuery(hql);
			List<Project> projects = (List<Project>) query.list();
			commit();
			return projects;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get projects", e);
		}
	}

	public Project getProject(Long projectId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Project where projectId= :projectId");
			q.setLong("projectId", projectId);
			Project product = (Project) q.uniqueResult();
			commit();
			return product;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get products", e);
		}
	}

	public Project updateProject(Project project) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().merge(project);
			commit();
			return project;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating project projectDAO: " + e.getMessage());
		}
	}

	public Project saveProject(Project project) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(project);
			commit();
			return project;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating project projectDAO: " + e.getMessage());
		}
	}
}
