/**
 * 
 */
package com.mms.vo;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @author Daddy
 *
 */
public class Invoice {

	private int id;
	private Timestamp invoiceDate;
	private String invoiceNo;
	private String clientName;
	private String clientAddress;
	private String clientOrderNo;
	private String clientContactName;
	private String clientContactPosition;
	private String jobDetails;
	private String jobTechnician;
	private String jobDesc;
	private double jobHours;
	private double jobRate;
	private BigDecimal jobTotal;
	private Blob jobImage;
	private BigDecimal jobCallOutCharge;
	private BigDecimal labourJobSubTotal;
	private String partsMatDetails;
	private int partsQty;
	private double partsRate;
	private BigDecimal partsTotal;
	private BigDecimal labourPartsSubTotal;
	private BigDecimal preGstTotal;
	private BigDecimal gst;
	private BigDecimal labourTotalCost;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the invoiceDate
	 */
	public Timestamp getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the clientAddress
	 */
	public String getClientAddress() {
		return clientAddress;
	}
	/**
	 * @param clientAddress the clientAddress to set
	 */
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	/**
	 * @return the clientOrderNo
	 */
	public String getClientOrderNo() {
		return clientOrderNo;
	}
	/**
	 * @param clientOrderNo the clientOrderNo to set
	 */
	public void setClientOrderNo(String clientOrderNo) {
		this.clientOrderNo = clientOrderNo;
	}
	/**
	 * @return the clientContactName
	 */
	public String getClientContactName() {
		return clientContactName;
	}
	/**
	 * @param clientContactName the clientContactName to set
	 */
	public void setClientContactName(String clientContactName) {
		this.clientContactName = clientContactName;
	}
	/**
	 * @return the clientContactPosition
	 */
	public String getClientContactPosition() {
		return clientContactPosition;
	}
	/**
	 * @param clientContactPosition the clientContactPosition to set
	 */
	public void setClientContactPosition(String clientContactPosition) {
		this.clientContactPosition = clientContactPosition;
	}
	/**
	 * @return the jobDetails
	 */
	public String getJobDetails() {
		return jobDetails;
	}
	/**
	 * @param jobDetails the jobDetails to set
	 */
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	/**
	 * @return the jobTechnician
	 */
	public String getJobTechnician() {
		return jobTechnician;
	}
	/**
	 * @param jobTechnician the jobTechnician to set
	 */
	public void setJobTechnician(String jobTechnician) {
		this.jobTechnician = jobTechnician;
	}
	/**
	 * @return the jobDesc
	 */
	public String getJobDesc() {
		return jobDesc;
	}
	/**
	 * @param jobDesc the jobDesc to set
	 */
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	/**
	 * @return the jobHours
	 */
	public double getJobHours() {
		return jobHours;
	}
	/**
	 * @param jobHours the jobHours to set
	 */
	public void setJobHours(double jobHours) {
		this.jobHours = jobHours;
	}
	/**
	 * @return the jobRate
	 */
	public double getJobRate() {
		return jobRate;
	}
	/**
	 * @param jobRate the jobRate to set
	 */
	public void setJobRate(double jobRate) {
		this.jobRate = jobRate;
	}
	/**
	 * @return the jobImage
	 */
	public Blob getJobImage() {
		return jobImage;
	}
	/**
	 * @param jobImage the jobImage to set
	 */
	public void setJobImage(Blob jobImage) {
		this.jobImage = jobImage;
	}
	/**
	 * @return the jobTotal
	 */
	public BigDecimal getJobTotal() {
		return jobTotal;
	}
	/**
	 * @param jobTotal the jobTotal to set
	 */
	public void setJobTotal(BigDecimal jobTotal) {
		this.jobTotal = jobTotal;
	}
	
	/**
	 * @return the jobCallOutCharge
	 */
	public BigDecimal getJobCallOutCharge() {
		return jobCallOutCharge;
	}
	/**
	 * @param jobCallOutCharge the jobCallOutCharge to set
	 */
	public void setJobCallOutCharge(BigDecimal jobCallOutCharge) {
		this.jobCallOutCharge = jobCallOutCharge;
	}
	/**
	 * @return the labourJobSubTotal
	 */
	public BigDecimal getLabourJobSubTotal() {
		return labourJobSubTotal;
	}
	/**
	 * @param labourJobSubTotal the labourJobSubTotal to set
	 */
	public void setLabourJobSubTotal(BigDecimal labourJobSubTotal) {
		this.labourJobSubTotal = labourJobSubTotal;
	}
	/**
	 * @return the partsMatDetails
	 */
	public String getPartsMatDetails() {
		return partsMatDetails;
	}
	/**
	 * @param partsMatDetails the partsMatDetails to set
	 */
	public void setPartsMatDetails(String partsMatDetails) {
		this.partsMatDetails = partsMatDetails;
	}
	/**
	 * @return the partsQty
	 */
	public int getPartsQty() {
		return partsQty;
	}
	/**
	 * @param partsQty the partsQty to set
	 */
	public void setPartsQty(int partsQty) {
		this.partsQty = partsQty;
	}
	/**
	 * @return the partsRate
	 */
	public double getPartsRate() {
		return partsRate;
	}
	/**
	 * @param partsRate the partsRate to set
	 */
	public void setPartsRate(double partsRate) {
		this.partsRate = partsRate;
	}
	/**
	 * @return the partsTotal
	 */
	public BigDecimal getPartsTotal() {
		return partsTotal;
	}
	/**
	 * @param partsTotal the partsTotal to set
	 */
	public void setPartsTotal(BigDecimal partsTotal) {
		this.partsTotal = partsTotal;
	}
	/**
	 * @return the labourPartsSubTotal
	 */
	public BigDecimal getLabourPartsSubTotal() {
		return labourPartsSubTotal;
	}
	/**
	 * @param labourPartsSubTotal the labourPartsSubTotal to set
	 */
	public void setLabourPartsSubTotal(BigDecimal labourPartsSubTotal) {
		this.labourPartsSubTotal = labourPartsSubTotal;
	}
	/**
	 * @return the preGstTotal
	 */
	public BigDecimal getPreGstTotal() {
		return preGstTotal;
	}
	/**
	 * @param preGstTotal the preGstTotal to set
	 */
	public void setPreGstTotal(BigDecimal preGstTotal) {
		this.preGstTotal = preGstTotal;
	}
	/**
	 * @return the gst
	 */
	public BigDecimal getGst() {
		return gst;
	}
	/**
	 * @param gst the gst to set
	 */
	public void setGst(BigDecimal gst) {
		this.gst = gst;
	}
	/**
	 * @return the labourTotalCost
	 */
	public BigDecimal getLabourTotalCost() {
		return labourTotalCost;
	}
	/**
	 * @param labourTotalCost the labourTotalCost to set
	 */
	public void setLabourTotalCost(BigDecimal labourTotalCost) {
		this.labourTotalCost = labourTotalCost;
	}
	
	
}
