package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userID;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_mobile")
	private String mobileNumber;
	@Column(name = "user_email")
	private String email;
	
	public AbstractUser() {
		super();
	}

	public AbstractUser(Integer userID, String userName, String password, String mobileNumber, String email) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}