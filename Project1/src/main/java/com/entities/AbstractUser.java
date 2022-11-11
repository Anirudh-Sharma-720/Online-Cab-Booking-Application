package com.entities;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="user_table")
public class AbstractUser {
	@Id
	@GeneratedValue
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@NotNull(message="username cannot be null")
	@NotBlank(message="username cannot be blank")
	private String username;
	@NotNull(message="password cannot be null")
	@NotBlank(message="password cannot be blank")
	private String password;
	@NotNull(message="mobile number cannot be null")
	@Pattern(regexp="(^$|[0-9]{10})", message="Please provide a valid mobile number")
	private String mobileNumber;
	@Pattern(regexp="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message="Please provide a valid email address")
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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