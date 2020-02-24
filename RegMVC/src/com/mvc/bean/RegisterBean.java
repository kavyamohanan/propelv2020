package com.mvc.bean;

import java.util.Date;

public class RegisterBean {

	private Integer slNo;
	private String fullName;
	private String email;
	private String userName;
	private String password;
	private String role;
	private String isActive;
	private String gender;
	private Date regDate;
	
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterBean(Integer slNo, String fullName, String email,
			String userName, String password, String role, String isActive,
			String gender, Date regDate) {
		super();
		this.slNo = slNo;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.gender = gender;
		this.regDate = regDate;
	}

	public RegisterBean(String fullName, String email, String userName,
			String password, String role, String isActive, String gender,
			Date regDate) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.gender = gender;
		this.regDate = regDate;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "RegisterBean [slNo=" + slNo + ", fullName=" + fullName
				+ ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", role=" + role + ", isActive=" + isActive
				+ ", gender=" + gender + ", regDate=" + regDate + "]";
	}

	
	
	
}