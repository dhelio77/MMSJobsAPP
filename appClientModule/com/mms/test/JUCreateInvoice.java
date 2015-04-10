/**
 * 
 */
package com.mms.test;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mms.service.IAccessAcctService;
import com.mms.vo.Invoice;
import com.mms.vo.User;

/**
 * @author Daddy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 	// redundant if you extends AbstractJUnit4SpringContextTests
@ContextConfiguration(locations={
		"classpath:/app_bean.xml", 	// For Access Account Service Implementation
		"classpath:/app_test.xml"}) // For Testing
public class JUCreateInvoice 
//extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private IAccessAcctService accessAcctSrvc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Invoice invoice = null;
	
	private static Timestamp invoiceDate = new Timestamp(Calendar.getInstance().getTimeInMillis());;
	private static String invoiceNo = "0301" ;
	private static String clientName = "Rodelio";
	private static String clientAddress = "13 Romi Avenue";
	private static String clientOrderNo = "Order123";
	private static String clientContactName = "Awell";
	private static String clientContactPosition = "Manager";
	private static String jobDetails = "Service Stove Burners";
	private static String jobTechnician = "Manny";
	private static String jobDesc = "Attended and service 6 burner stove. Note: Valves may require replacing";
	private static double jobHours = 3.5;
	private static double jobRate = 60.50;
	private static BigDecimal jobTotal = new BigDecimal(jobHours * jobRate);
	private static Blob jobImage = null;
	private static BigDecimal jobCallOutCharge = new BigDecimal(75.00);
	private static BigDecimal labourJobSubTotal = jobTotal.add(jobCallOutCharge);
	private static String partsMatDetails = "Parts and Materials";
	private static int partsQty = 100;
	private static double partsRate = 79.90;
	private static BigDecimal partsTotal = new BigDecimal(partsQty * partsRate);
	private static BigDecimal labourPartsSubTotal = partsTotal.add(labourJobSubTotal);
	private static BigDecimal preGstTotal = labourPartsSubTotal;
	private static BigDecimal gst = labourPartsSubTotal.multiply(new BigDecimal(0.10));
	private static BigDecimal labourTotalCost = preGstTotal.add(gst);
	
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
		String del_table = "DELETE FROM TEST.TA_INVOICE";
		getJdbcTemplate().execute(del_table);
	}
	
	@Test
	public void createInvoice() {
		setInvoice();
		getAccessAcctService().createInvoice(invoice);
	}
	
	private void setInvoice() {
		invoice = new Invoice();
		invoice.setInvoiceDate(invoiceDate);
		invoice.setInvoiceNo(invoiceNo);
		invoice.setClientName(clientName);
		invoice.setClientAddress(clientAddress);
		invoice.setClientOrderNo(clientOrderNo);
		invoice.setClientContactName(clientContactName);
		invoice.setClientContactPosition(clientContactPosition);
		invoice.setJobDetails(jobDetails);
		invoice.setJobTechnician(jobTechnician);
		invoice.setJobDesc(jobDesc);
		invoice.setJobHours(jobHours);
		invoice.setJobRate(jobRate);
		invoice.setJobTotal(jobTotal);
		invoice.setJobImage(jobImage);
		invoice.setJobCallOutCharge(jobCallOutCharge);
		invoice.setLabourJobSubTotal(labourJobSubTotal);
		invoice.setPartsMatDetails(partsMatDetails);
		invoice.setPartsQty(partsQty);
		invoice.setPartsRate(partsRate);
		invoice.setPartsTotal(partsTotal);
		invoice.setLabourPartsSubTotal(labourPartsSubTotal);
		invoice.setPreGstTotal(preGstTotal);
		invoice.setGst(gst);
		invoice.setLabourTotalCost(labourTotalCost);
	}
	
}
