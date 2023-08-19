package com.app.service;

import java.util.List;

import com.app.Entity.CarService;
import com.app.Entity.Cars;

public interface CarServiceService {
	
	public List<CarService> findAllCarService();
	public CarService findCarServiceById(int theId);
	public void saveCarService(CarService theCarService);
	public void deleteCarServiceById(int theId);	


}
