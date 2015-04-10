/**
 * 
 */
package com.mms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mms.dao.IAccessAcct;
import com.mms.service.IAccessAcctService;
import com.mms.util.InvoiceGenerator;

/**
 * @author Daddy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUInvoiceGenerator {

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	/**
	 * @return the accessAcctSrvc
	 */
	public IAccessAcctService getAccessAcctSrvc() {
		return accessAcctSrvc;
	}

	/**
	 * @param accessAcctSrvc the accessAcctSrvc to set
	 */
	public void setAccessAcctSrvc(IAccessAcctService accessAcctSrvc) {
		this.accessAcctSrvc = accessAcctSrvc;
	}

	@Test
	public void generateInvoice() {
		System.out.println("JU Invoice: "+getAccessAcctSrvc().getLatestInvoice());
	}

}
