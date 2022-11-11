package com.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin_table")
public class Admin extends AbstractUser {
	@NotNull(message="Admin Id cannot be null")
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
}