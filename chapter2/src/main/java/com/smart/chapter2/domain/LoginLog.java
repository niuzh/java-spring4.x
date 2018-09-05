/**
 * 
 */
package com.smart.chapter2.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志信息
 * @author niu
 */
public class LoginLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096058059203636352L;
	private int loginLogId;
	private int userId;
	private String ip;
	private Date loginDate;
	/**
	 * @return the loginLogId
	 */
	public int getLoginLogId() {
		return loginLogId;
	}
	/**
	 * @param loginLogId the loginLogId to set
	 */
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
