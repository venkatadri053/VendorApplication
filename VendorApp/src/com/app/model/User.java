package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_TAB")
public class User {
	@Id
	@GeneratedValue(generator="sample")
	@SequenceGenerator(name="sample",sequenceName="USER_SEQ")
	@Column(name="u_id")
	private int userId;
	@Column(name="u_name")
	private String userName;
	@Column(name="u_mail")
	private String userEmail;
	@Column(name="u_mobile")
	private String userMobile;
	@Column(name="u_addr")
	private String userAddr;
	@Column(name="pwd")
	private String password;
	
	public User() {
	}
	public User(int userId) {
		this.userId = userId;
	}

	public User(int userId, String userName, String userEmail,
			String userMobile, String userAddr, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userAddr = userAddr;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userMobile=" + userMobile
				+ ", userAddr=" + userAddr + ", password=" + password + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
