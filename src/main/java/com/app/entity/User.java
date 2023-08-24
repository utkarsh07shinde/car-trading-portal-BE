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
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	@OneToOne(mappedBy = "user_id",cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(mappedBy = "user_id",cascade = CascadeType.ALL)
	private Buyer buyer;
	
	@OneToOne(mappedBy = "user_id",cascade = CascadeType.ALL)
	//@JoinColumn(name = "user_id")
	private Seller seller;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(int user_id, String firstName, String lastName, String email, String password, Admin admin, Buyer buyer,
			Seller seller) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.buyer = buyer;
		this.seller = seller;
	}




	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
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
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", firstname=" + firstName + ", lastname=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}	
}
