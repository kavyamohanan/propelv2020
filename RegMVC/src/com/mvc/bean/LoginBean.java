package com.mvc.bean;

public class LoginBean {

	//---instance variables
	private String userName;
	private String password;

	//---default Constructor
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	//---parameterized constructor
	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	//getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//to String method
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password
				+ "]";
	}

}
