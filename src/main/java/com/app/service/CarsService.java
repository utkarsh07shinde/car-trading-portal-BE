package com.app.service;

import java.util.List;

import com.app.entity.Cars;

public interface CarsService {
	
	public List<Cars> findAllCars();
	public List<Cars> searchCarsByCity(String city);
	public Cars findCarById(int theId);
	public void saveCar(Cars theCars);
	public void deleteCarById(int theId);	

}
