package com.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carts")
public class Carts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private int cartId;
	
	
//	@Column(name = "cartDate")
//	private Date cartDate;
	
	@ManyToOne
//	@JsonIgnore
    @JoinColumn(name = "buyerId",nullable = false)
	private Buyer buyerId;
	
	@OneToOne()
	//@JsonIgnore
    @JoinColumn(name = "car_id")
	private Cars car_id;
	
//	@Column(name = "quantity")
//	private int quantity;
	
	@Column(name = "price")
	private double price;

	

	public Carts() {
		super();
	}



	public Carts(int cartId, Buyer buyerId, Cars car_id, double price) {
		super();
		this.cartId = cartId;
		this.buyerId = buyerId;
		this.car_id = car_id;
		this.price = price;
	}



	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public Buyer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}


	public Cars getCar_id() {
		return car_id;
	}



	public void setCar_id(Cars car_id) {
		this.car_id = car_id;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Carts [cartId=" + cartId + ", buyerId=" + buyerId + ", car_id=" + car_id + ", price=" + price + "]";
	}

}

