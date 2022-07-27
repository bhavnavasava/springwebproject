package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	@NotBlank
	String firstName;
	@NotBlank
	String lastName;
	@NotBlank
	String email;
	@NotBlank
	@NotBlank
	String password;
	
	String userType;
	Integer userId;
	

	public String getFirstName() {
		return firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
