package com.app.service;

import java.util.List;

import com.app.Entity.Cars;

public interface CarsService {
	
	public List<Cars> findAllCars();
	public Cars findCarById(int theId);
	public void saveCar(Cars theCars);
	public void deleteCarById(int theId);	

}
