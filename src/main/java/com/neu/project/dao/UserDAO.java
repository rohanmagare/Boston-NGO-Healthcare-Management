package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Email;
import com.neu.project.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public List<User> getAllUsers() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User");
			List<User> users = (List<User>) q.list();
			commit();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user ", e);
		}
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public User getUserFromUserName(String username) throws UserException {

		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public User get(Long userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userId= :userId");
			q.setLong("userId", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public List<User> getUsersByRole(String role) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where role= :role");
			q.setString("role", role);
			List<User> users = (List<User>) q.list();
			commit();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + role, e);
		}
	}

	public User register(User u) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Email email = new Email(u.getEmail().getEmailAddress());
			User user = new User(u.getUserName(), u.getPassword());
			user.setFilename(u.getFilename());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(email);
			user.setAddress(u.getAddress());
			user.setMiddleName(u.getMiddleName());
			user.setPhoneNumber(u.getPhoneNumber());
			user.setRole(u.getRole());
			email.setUser(user);
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUserName(), e);
		}
	}
}