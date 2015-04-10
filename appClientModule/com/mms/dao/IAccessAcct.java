/**
 * 
 */
package com.mms.dao;

import java.util.Collection;

import com.mms.exception.AuthenticationException;
import com.mms.vo.Invoice;
import com.mms.vo.Login;
import com.mms.vo.User;

/**
 * @author Daddy
 *
 */
public interface IAccessAcct {

	/*
	 * Login
	 */
	void insertLogin(Login Login);
	
	void updateLogin(Login login);
	
	Login getLogin(Login login);
	
	Login getLoginWithID(Login login);
	
	Collection<Login> getLogins();
	
	/*
	 * User
	 */
	void insertOrUpdateUser(User user);
	
	void updateUser(User user);
	
	User getUser(User user);
	
	User getUser(String userName, String passWord) throws AuthenticationException;
	
	User getUserWithID(User user);
	
	Collection<User> getUsers();
	
	/*
	 * Invoice
	 */
	String getLatestInvoice();
	
	void createInvoice(Invoice invoice);
	
}
