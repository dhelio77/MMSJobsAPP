/**
 * 
 */
package com.mms.service;

import java.util.Collection;

import com.mms.dao.IAccessAcct;
import com.mms.exception.AuthenticationException;
import com.mms.vo.Invoice;
import com.mms.vo.Login;
import com.mms.vo.User;
import com.mms.service.IAccessAcctService;

/**
 * @author Daddy
 *
 */
public class AccessAcctServiceImpl implements IAccessAcctService {

	private IAccessAcct accessAcct;

	
	/**
	 * @return accessAcct
	 */
	public IAccessAcct getAccessAcct() {
		return accessAcct;
	}

	/**
	 * @param accessAcct
	 */
	public void setAccessAcct(IAccessAcct accessAcct) {
		this.accessAcct = accessAcct;
	}

	/**
	 * User
	 */
	@Override
	public void updateUser(User user) {
		if (user != null) {
			getAccessAcct().updateUser(user);
		}
	}

	@Override
	public void createUser(User user) {
		if (user != null) {
			getAccessAcct().insertOrUpdateUser(user);
		}
	}

	@Override
	public User getUser(User user) {
		if (user != null) {
			return getAccessAcct().getUser(user);
		}
		return null;
	}

	@Override
	public Collection<User> getUsers() {
		return getAccessAcct().getUsers();
	}
	
	@Override
	public User getUserWithID(User user) {
		if (user != null) {
			return getAccessAcct().getUserWithID(user);
		}
		return null;
	}
	
	@Override
	public User getUser(String username, String password)
	throws AuthenticationException {
		if (username != null && password != null) {
			User user = getAccessAcct().getUser(username, password);
			System.out.println("User from Service: "+user);
			if (user==null) throw new AuthenticationException("Service: User object is null!");
			else return user;
		}
		return null;
	}

	/**
	 * Login
	 */
	@Override
	public void createLogin(Login login) {
		if (login != null) {
			getAccessAcct().insertLogin(login);
		}
	}

	@Override
	public void updateLogin(Login login) {
		if (login != null) {
			getAccessAcct().updateLogin(login);
		}
	}

	@Override
	public Login getLogin(Login login) {
		if (login != null) {
			getAccessAcct().getLogin(login);
		}
		return null;
	}

	@Override
	public Login getLoginWithID(Login login) {
		if (login != null) {
			return getAccessAcct().getLoginWithID(login);
		}
		return null;
	}

	@Override
	public Collection<Login> getLogins() {
		return getAccessAcct().getLogins();
	}

	@Override
	public String getLatestInvoice() {
		return getAccessAcct().getLatestInvoice();
	}

	@Override
	public void createInvoice(Invoice invoice) {
		getAccessAcct().createInvoice(invoice);
		
	}

}
