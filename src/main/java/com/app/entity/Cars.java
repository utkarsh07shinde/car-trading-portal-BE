package com.app.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cars")
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id ")
	private int car_id ; 
	
	@ManyToOne()
    @JoinColumn(name = "categoryId",nullable = false)
	private Categories categoryId ; 
	
	@ManyToOne()
    @JoinColumn(name = "brandId",nullable = false)
	private Brands brandId ; 
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JsonIgnore
	@OneToOne()
    @JoinColumn(name = "sellerId",nullable = false)
	private Seller sellerId ; 
	
	@OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
	private List<CarService> carService;
	
	//@OneToOne()
	//private Carts carts;
		
	@Column(name = "model ")
	private String model ; 
	
	@Column(name = " year")
	private String year ;
	
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
	
	@Column(name="carImage")
	private String carImage;
	
	@Column(name="city")
	private String city;
	
	

	public Cars() {
		super();
	}

	public Cars(int carId, Categories categoryId, Brands brandId, Seller sellerId, String model, String year, int mileage,
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
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

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
		
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	
	
}
