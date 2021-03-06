/**
 * 
 */
package com.mms.vo;

import java.sql.Timestamp;

/**
 * @author Daddy
 *
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private String accessAcct;
	private Boolean isLogged;
	private Timestamp updateDatetime;
	private Timestamp createDatetime;

	/**
	 * 
	 */
	public User() {
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
	 * @return the isLogged
	 */
	public Boolean getIsLogged() {
		return isLogged;
	}

	/**
	 * @param isLogged the isLogged to set
	 */
	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the accessAcct
	 */
	public String getAccessAcct() {
		return accessAcct;
	}

	/**
	 * @param accessAcct the accessAcct to set
	 */
	public void setAccessAcct(String accessAcct) {
		this.accessAcct = accessAcct;
	}




	/**
	 * @return the updateDatetime
	 */
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * @param updateDatetime the updateDatetime to set
	 */
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	/**
	 * @return the createDatetime
	 */
	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * @param createDatetime the createDatetime to set
	 */
	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}
	
}
