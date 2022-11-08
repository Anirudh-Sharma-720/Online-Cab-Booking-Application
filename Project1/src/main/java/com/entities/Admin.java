package com.entities;
import javax.persistence.*;

@Entity
@Table(name="admin_table")
public class Admin extends AbstractUser {
//	@Id
//	@GeneratedValue
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
}