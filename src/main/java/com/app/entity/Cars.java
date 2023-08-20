package com.app.entity;

import java.time.Year;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id ")
	private int car_id ; 
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
	private Categories categoryId ; 
	
	@ManyToOne
    @JoinColumn(name = "brandId")
	private Brands brandId ; 
	
	@ManyToOne
    @JoinColumn(name = "sellerId")
	private Seller sellerId ; 
	
	@Column(name = "model ")
	private String model ; 
	
	@Column(name = " year")
	private Year year ;
	
	@Column(name = "mileage ")
	private int mileage ; 
	
	@Column(name = "color  ")
	private String color ; 
	
	@Column(name = " price ")
	private double price ;
	
	@Column(name = "fuelType ")
	private String fuelType ;
	
	@Column(name = "kmsDriven")
	private int kmsDriven ;

	public Cars() {
		super();
	}

	public Cars(int carId, Categories categoryId, Brands brandId, Seller sellerId, String model, Year year, int mileage,
			String color, double price, String fuelType, int kmsDriven) {
		super();
		this.car_id = carId;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.sellerId = sellerId;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.color = color;
		this.price = price;
		this.fuelType = fuelType;
		this.kmsDriven = kmsDriven;
	}

	public int getCarId() {
		return car_id;
	}

	public void setCarId(int carId) {
		this.car_id = carId;
	}

	public Categories getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Categories categoryId) {
		this.categoryId = categoryId;
	}

	

	public Brands getBrandId() {
		return brandId;
	}

	public void setBrandId(Brands brandId) {
		this.brandId = brandId;
	}

	public Seller getSellerId() {
		return sellerId;
	}

	public void setSellerId(Seller sellerId) {
		this.sellerId = sellerId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getKmsDriven() {
		return kmsDriven;
	}

	public void setKmsDriven(int kmsDriven) {
		this.kmsDriven = kmsDriven;
	}
	
	
}
