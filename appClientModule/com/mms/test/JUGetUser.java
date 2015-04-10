/**
 * 
 */
package com.mms.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
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
public class JUGetUser
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private User user = null;
	
	private static String USERNAME = "rhodel";
	
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
	public void getUser() {
		user = setUser();
		user = getAccessAcctService().getUser(user);
		assertThat("User is NULL", user, is(notNullValue()));
		assertThat("User is invalid", user.getUsername(), is(USERNAME));
	}
	
	private User setUser() {
		user = new User();
		user.setUsername(USERNAME);
		return user;
	}
	
}
