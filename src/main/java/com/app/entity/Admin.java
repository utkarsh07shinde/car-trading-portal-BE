package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int adminId ;
	@Column(name="adminname")
	private String adminname;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminname, String email, String username, String password) {
		super();
		this.adminId = adminId;
		this.adminname = adminname;
		this.email = email;
		this.username = username;
		this.password = password;
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
	
	
}
