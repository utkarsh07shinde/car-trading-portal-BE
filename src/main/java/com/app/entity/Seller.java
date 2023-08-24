package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seller")
public class Seller {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sellerId")
	private int sellerId;
	@Column(name = "sellerName")
	private String sellerName;
	@Column(name = "email")
	private String email;
	//@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "user_id",nullable = true)
    private User user_id;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "phone")
	private String phone;
	
	//@OneToMany(mappedBy = "sellerId",fetch = FetchType.LAZY)
	//@OneToOne(mappedBy = "sellerId",fetch = FetchType.LAZY,orphanRemoval = true)
	//private Cars cars;
	
	public Seller() {
		super();
	}

	public Seller(int sellerId, String sellerName, String email, String username, String password, String address,
			String city, String phone) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", email=" + email + ", user_id="
				+ user_id + ", address=" + address + ", city=" + city + ", phone=" + phone + "]";
	}
	
	
	
	

}
