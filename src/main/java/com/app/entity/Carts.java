package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Carts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartId")
	private int cartId;
	
	
	@Column(name = "cartDate")
	private Date cartDate;
	
	@ManyToOne
    @JoinColumn(name = "buyerId")
	private Buyer buyerId;
	
	@ManyToOne
    @JoinColumn(name = "car_id")
	private Cars car_id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "totalPrice")
	private double totalPrice;

	public Carts() {
		super();
	}

	public Carts(int cartId, Date cartDate, Buyer buyerId, Cars carId, int quantity, double totalPrice) {
		super();
		this.cartId = cartId;
		this.cartDate = cartDate;
		this.buyerId = buyerId;
		this.car_id = carId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	public Buyer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}

	public Cars getCarId() {
		return car_id;
	}

	public void setCarId(Cars carId) {
		this.car_id = carId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}

