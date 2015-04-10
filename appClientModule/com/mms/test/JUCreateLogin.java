/**
 * 
 */
package com.mms.test;

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
 * This creates the Login table with the userid and the start_log when the user logs in.
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUCreateLogin 
//extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Login login = null;
	
	private static String USERNAME = "rhodel";
	private static Timestamp START_LOG = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
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
	@Before
	public void clearLoginTable() throws Exception {
		String del_table = "DELETE FROM TEST.TA_LOGIN";
		getJdbcTemplate().execute(del_table);
	}
	
	@Test
	public void createLogin() {
		login = setLogin();
		getAccessAcctService().createLogin(login);
	}
	
	private Login setLogin() {
		login = new Login();
		login.setUsername(USERNAME);
		login.setStartLog(START_LOG);
		return login;
	}
	
}
