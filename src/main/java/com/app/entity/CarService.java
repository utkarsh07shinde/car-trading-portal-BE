package com.app.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " CarService ")
public class CarService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serviceId")
	private int serviceId; 
	
	@Column(name = "carId")
	private int carId ;
	
	@Column(name = "serviceDate ")
	private Date serviceDate ;
	
	@Column(name = "serviceCost ")
	private double serviceCost;

	public CarService() {
		super();
	}

	public CarService(int serviceId, int carId, Date serviceDate, double serviceCost) {
		super();
		this.serviceId = serviceId;
		this.carId = carId;
		this.serviceDate = serviceDate;
		this.serviceCost = serviceCost;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
	
	

}
