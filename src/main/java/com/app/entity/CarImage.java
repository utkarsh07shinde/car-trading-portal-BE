package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carimage")
public class CarImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imageId")
	private int imageId ; 
	private int carId;  
	private String imageUrl ;
	public CarImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarImage(int imageId, int carId, String imageUrl) {
		super();
		this.imageId = imageId;
		this.carId = carId;
		this.imageUrl = imageUrl;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
