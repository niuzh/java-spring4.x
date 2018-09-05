package com.smart.chapter2.command;

/**
 * 收集请求参数
 * 
 * @author niu 2018-09-04
 */
public class LoginCommand {
	private String userName;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
