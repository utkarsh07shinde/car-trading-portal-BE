package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_Id")
	private int buyerId;
	@Column(name = "buyer_name")
	private String buyerName;
	@Column(name = "email")
	private String email;
	@OneToOne
    @JoinColumn(name = "user_id",nullable = true)
    private User user_id;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "buyerId",cascade = CascadeType.ALL)
	private List<Carts> carts;
	

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(int buyerId, String buyerName, String email, String username, String password, String address,
			String city, String phone) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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
	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", email=" + email + ", user_id=" + user_id
				+ ", address=" + address + ", city=" + city + ", phone=" + phone + ", carts=" + carts + "]";
	}
	
	
}
