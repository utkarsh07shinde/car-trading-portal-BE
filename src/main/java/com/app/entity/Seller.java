package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sellerId")
	private int sellerId;
	@Column(name = "sellerName")
	private String sellerName;
	@Column(name = "email")
	private String email;
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "phone")
	private String phone;
	
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


	public User getUserId() {
		return user_id;
	}

	public void setUserId(User userId) {
		this.user_id = userId;
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
	
	
	
	

}
