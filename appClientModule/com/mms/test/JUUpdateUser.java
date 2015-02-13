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
import com.mms.vo.User;

/**
 * @author Daddy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUUpdateUser 
//extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private User user = null;
	
	private static String USERID = "rhodel";
	private static Boolean ISLOGGED = new Boolean(true);
	private static Timestamp UPDATE_DATETIME = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
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
	public void checkUser() {
		assertThat("There are no users", getAccessAcctService().getUsers(), is(notNullValue()));
	}

	@Test
	public void updateUser() {
		user = setUser(getUser());
		getAccessAcctService().updateUser(user);
	}
	
	private User getUser() {
		user = new User();
		user.setUserId(USERID);
		return getAccessAcctService().getUser(user);
	}
	
	private User setUser(User user) {
		user.setId(user.getId());
		user.setIsLogged(ISLOGGED);
		user.setUpdateDatetime(UPDATE_DATETIME);
		return user;
	}
	
}
