/**
 * 
 */
package com.mms.test;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mms.service.IAccessAcctService;
import com.mms.vo.User;

/**
 * @author Daddy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUCreateUser 
//extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private User user = null;
	
	private static String USERNAME = "awell";
	private static String PASSWORD = "pogi";
	private static String ACCESS_ACCT = "admin"; //
	private static Boolean ISLOGGED = null;
	private static Timestamp UPDATE_DATETIME = new Timestamp(Calendar.getInstance().getTimeInMillis());
	private static Timestamp CREATE_DATETIME = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
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


	/**
	 * @throws java.lang.Exception
	 */
//	@Before
	@Ignore
	public void clearUserTable() throws Exception {
		String del_table = "DELETE FROM TEST.TA_USER";
		getJdbcTemplate().execute(del_table);
	}
	
	@Test
	public void createUser() {
		user = setuser();
		getAccessAcctService().createUser(user);
	}
	
	private User setuser() {
		user = new User();
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setAccessAcct(ACCESS_ACCT);
		user.setIsLogged(ISLOGGED);
		user.setUpdateDatetime(UPDATE_DATETIME);
		user.setCreateDatetime(CREATE_DATETIME);
		return user;
	}
	
}
