/**
 * 
 */
package com.mms.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.mms.dao.IAccessAcct;
import com.mms.vo.Login;
import com.mms.vo.User;

/**
 * @author Daddy
 *
 */
public class AccessAcctDao implements IAccessAcct {

	private SessionFactory sessionFactory;
	
	/**
	 * 
	 */
	public AccessAcctDao() {
		
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * User
	 */
	
	@Override
	public void insertOrUpdateUser(User user) throws UnsupportedOperationException {
		System.out.println("Inserting/Updating User...");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println("Exception caught.");
			e.printStackTrace();
			throw new UnsupportedOperationException();
		} 
		System.out.println("User Inserted/Updated.");
	}
	
	@Override
	public void updateUser(User user) {
		System.out.println("Updating User...");
		try {
			getSessionFactory().getCurrentSession().update(user);
		} catch (HibernateException e) {
			System.out.println("Exception caught.");
			e.printStackTrace();
			throw new UnsupportedOperationException();
		}
		System.out.println("User updated.");
	}

	/**
	 * This retrieve the User object using the userid.
	 * @param user
	 * @return User object
	 * @throws UnsupportedOperationException
	 * 
	 * /** TODO better put the mapping to constant
	 *     Eg. com.mms.vo.User
	 */
	public User getUser(User user) throws UnsupportedOperationException {
		return (User) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.User where userid = :userId") 
				.setParameter("userId", (String) user.getUserId())
				.uniqueResult();
	}
	
	/**
	 * This retrieve the User object using the id pk.
	 * @param user
	 * @return User object
	 * @throws UnsupportedOperationException
	 */
	public User getUserWithID(User user) throws UnsupportedOperationException {
		return (User) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.User where id = :id")
				.setParameter("id", (int) user.getId())
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<User> getUsers() throws UnsupportedOperationException {
		return getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.User")
				.list();
	}
	
	/**
	 * Login
	 */
	
	@Override
	public void insertLogin(Login login) {
		System.out.println("Inserting/Updating Login...");
		try {
			getSessionFactory().getCurrentSession().save(login);
		} catch(Exception e) {
			System.out.println("Exception caught.");
			e.printStackTrace();
			throw new UnsupportedOperationException();
		}
		System.out.println("Login Inserted/Updated.");
	}
	
	@Override
	public void updateLogin(Login login) {
		System.out.println("Updating Login...");
		try {
			getSessionFactory().getCurrentSession().update(login);
		} catch (HibernateException e) {
			System.out.println("Exception caught.");
			e.printStackTrace();
			throw new UnsupportedOperationException();
		}
		System.out.println("Login updated.");
	}
	
	/**
	 * This retrieve the Login object using the userid.
	 * @param login
	 * @return Login object
	 * @throws UnsupportedOperationException
	 */
	public Login getLogin(Login login) throws UnsupportedOperationException {
		return (Login) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.Login where userid = :userId")
				.setParameter("userId", (String) login.getUserId())
				.uniqueResult();
	}
	
	/**
	 * This retrieve the Login object using the id pk.
	 * @param login
	 * @return Login object
	 * @throws UnsupportedOperationException
	 */
	public Login getLoginWithID(Login login) throws UnsupportedOperationException {
		System.out.println("["+login.getId()+"]");
		return (Login) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.Login where id = :id")
				.setParameter("id", login.getId())
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Login> getLogins() throws UnsupportedOperationException {
		return getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.Login")
				.list();
	}

}
