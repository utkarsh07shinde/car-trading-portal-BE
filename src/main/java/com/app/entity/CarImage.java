package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carimage")
public class CarImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imageId")
	private int imageId ; 
	
	//@ManyToOne
    //@JoinColumn(name = "car_id")
	//private Cars car_id;  
	
	@Column(name="imageUrl")
	private String imageUrl ;
	
	public CarImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarImage(int imageId, Cars carId, String imageUrl) {
		super();
		this.imageId = imageId;
	//	this.car_id = carId;
		this.imageUrl = imageUrl;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
//	public Cars getCarId() {
//		return car_id;
//	}
//	public void setCarId(Cars carId) {
//		this.car_id = carId;
//	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
