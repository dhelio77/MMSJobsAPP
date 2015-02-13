/**
 * 
 */
package com.mms.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mms.service.IAccessAcctService;
import com.mms.vo.Login;

/**
 * @author Daddy
 * 
 * This updates the end_log of the Login table when the user logs out.
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUUpdateLogin 
//extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Login login = null;
	
	private static int ID = 2;
	private static Timestamp END_LOG = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	/**
	 * @return the accessAccountService
	 */
	public IAccessAcctService getAccessAcctService() {
		return accessAcctSrvc;
	}
	
	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	@Before
	public void checkLogin() {
		assertThat("There are no login records", getAccessAcctService().getLogins(), is(notNullValue()));
	}

	@Test
	public void updateLogin() {
		login = setLogin(getLogin());
		getAccessAcctService().updateLogin(login);
	}
	
	private Login getLogin() {
		login = new Login();
		login.setId(ID);
		login = getAccessAcctService().getLoginWithID(login);
		return login;
	}
	
	private Login setLogin(Login login) {
		login.setId(login.getId());
		login.setUserId(login.getUserId());
		login.setEndLog(END_LOG);
		return login;
	}
	
}
