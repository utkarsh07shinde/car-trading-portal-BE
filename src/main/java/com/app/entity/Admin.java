package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adminId")
	private int adminId ;
	@Column(name="adminname")
	private String adminname;
	@Column(name="email")
	private String email;
	@OneToOne()
	@JoinColumn(name = "user_id",nullable = true)
    private User user_id;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminname, String email, String username, String password) {
		super();
		this.adminId = adminId;
		this.adminname = adminname;
		this.email = email;
		
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUserId() {
		return user_id;
	}
	public void setUserId(User userId) {
		this.user_id = userId;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminname=" + adminname + ", email=" + email + ", user_id=" + user_id
				+ "]";
	}
	
	
	
	
}
