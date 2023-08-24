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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = " CarService ")
public class CarService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serviceId")
	private int serviceId; 
	
	@JsonIgnore
	@ManyToOne()
    @JoinColumn(name = "car_id",nullable = false)
	private Cars car ;
	
	@Column(name = "serviceDate ")
	private Date serviceDate ;
	
	@Column(name = "serviceCost ")
	private double serviceCost;

	public CarService() {
		super();
	}

	public CarService(int serviceId, Cars carId, Date serviceDate, double serviceCost) {
		super();
		this.serviceId = serviceId;
		this.car = carId;
		this.serviceDate = serviceDate;
		this.serviceCost = serviceCost;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "CarService [serviceId=" + serviceId + ", car=" + car + ", serviceDate=" + serviceDate + ", serviceCost="
				+ serviceCost + "]";
	}
	
	

}
