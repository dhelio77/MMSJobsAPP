/**
 * 
 */
package com.mms.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.mms.exception.AuthenticationException;
import com.mms.util.InvoiceGenerator;
import com.mms.vo.Invoice;
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

//	User
	
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
	 * This retrieve the User object using the username.
	 * @param user
	 * @return User object
	 * @throws UnsupportedOperationException
	 */
	public User getUser(User user) throws UnsupportedOperationException {
		return (User) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.User where username = :username") 
				.setParameter("username", (String) user.getUsername())
				.uniqueResult();
	}
	
	/**
	 * This retrieves the User object using username and password
	 * @param String userName, String passWd
	 * @return User object
	 * @throws UnsupportedOperationException
	 */
	public User getUser(String userName, String passWord) throws AuthenticationException {
		String query = "from com.mms.vo.User u where u.username = :userName and u.password = :passWord";
		System.out.println("Query: "+query);
		System.out.println("Param: ["+userName+","+passWord+"]");
		User user = (User) getSessionFactory().getCurrentSession()
				.createQuery(query) 
				.setParameter("userName", userName)
				.setParameter("passWord", passWord)
				.uniqueResult();
		System.out.println("User from DAO: "+user);
		if (user==null) throw new AuthenticationException("DAO: User object is null!");
		return user;
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
	
//	Login
	
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
	 * This retrieve the Login object using the username.
	 * @param login
	 * @return Login object
	 * @throws UnsupportedOperationException
	 */
	public Login getLogin(Login login) throws UnsupportedOperationException {
		return (Login) getSessionFactory().getCurrentSession()
				.createQuery("from com.mms.vo.Login where username = :username")
				.setParameter("username", (String) login.getUsername())
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
	
//	Invoice
	
	/**
	 * 
	 * @param sessionFactory
	 * @return
	 */
	@Override
	public String getLatestInvoice() throws UnsupportedOperationException {
		String newInvoice = null;
		String query = "from com.mms.vo.Invoice i where i.id = (select max(id) from i)";
//		String query = "from com.mms.vo.Invoice";
		System.out.println("Query: "+query);
		Invoice invoice = (Invoice) getSessionFactory().getCurrentSession()
				.createQuery(query)
				.uniqueResult();
		
		System.out.println("Extracted Invoice: "+invoice);
		if (invoice!=null) {
			System.out.println("Generating new invoice from latest invoice number...");
			newInvoice = InvoiceGenerator.getInstance().generateInvoice(invoice);
		} else {
			System.out.println("Generating the first invoice number...");
			newInvoice = InvoiceGenerator.getInstance().generateInvoice();
		}
		
		return newInvoice;
	}

	/**
	 * 
	 */
	@Override
	public void createInvoice(Invoice invoice) {
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(invoice);
		} catch (HibernateException e) {
			System.out.println("HibernateException: createInvoice()!");
			e.printStackTrace();
		}
	}
	
	
}
