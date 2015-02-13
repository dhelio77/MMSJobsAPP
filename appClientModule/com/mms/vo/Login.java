/**
 * 
 */
package com.mms.vo;

import java.sql.Timestamp;

/**
 * @author Daddy
 *
 */
public class Login {
	
	private int id;
	private String userId;
	private Timestamp startLog;
	private Timestamp endLog;

	/**
	 * 
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the startLog
	 */
	public Timestamp getStartLog() {
		return startLog;
	}

	/**
	 * @param startLog the startLog to set
	 */
	public void setStartLog(Timestamp startLog) {
		this.startLog = startLog;
	}

	/**
	 * @return the endLog
	 */
	public Timestamp getEndLog() {
		return endLog;
	}

	/**
	 * @param endLog the endLog to set
	 */
	public void setEndLog(Timestamp endLog) {
		this.endLog = endLog;
	}


}
