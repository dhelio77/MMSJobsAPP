/**
 * 
 */
package com.mms.util;

import java.util.Calendar;

import com.mms.vo.Invoice;

/**
 * @author Daddy
 *
 */
public class InvoiceGenerator {

	private static InvoiceGenerator instance = null; 
	
	/**
	 * 
	 */
	private InvoiceGenerator() {
		System.out.println("InvoiceGenerator() instantiated!");
	}
	
	/**
	 * 
	 * @return
	 */
	public static synchronized InvoiceGenerator getInstance() {
		if (instance==null) {
			synchronized (InvoiceGenerator.class) {
				if (instance==null) {
					System.out.println("InvoiceGenerator.getInstance(): First time getInstance was invoked!");
					instance = new InvoiceGenerator();
				}
			}
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public final String generateInvoice(Invoice invoice) {
		StringBuilder invoiceNo = new StringBuilder();
		StringBuilder newInvLastDig = new StringBuilder();
		String invTmp = invoice.getInvoiceNo();
		System.out.println("Invoice No from DB: "+invTmp);
		Integer invLastDig = new Integer(invTmp.substring(2)) + 1;
		if (invLastDig<10) {
			newInvLastDig.append("0").append(invLastDig);
		} else {
			newInvLastDig.append(invLastDig);
		}
		invoiceNo.append(getMonth()).append(newInvLastDig);
		System.out.println("New Invoice No: "+invoiceNo.toString());
		return invoiceNo.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public final String generateInvoice() {
		StringBuilder invoiceNo = new StringBuilder();
		invoiceNo.append(getMonth()).append("01");
		System.out.println("New Invoice No: "+invoiceNo.toString());
		return invoiceNo.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private static final String getMonth() {
		StringBuilder invoice = new StringBuilder();
		Integer mo = Calendar.getInstance().getTime().getMonth()+1;
		if (mo<10) {
			invoice.append("0").append(mo);
		} else {
			invoice.append(mo);
		}
		return invoice.toString();
	}
	
}
