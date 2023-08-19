package com.app.service;

import java.util.List;

import com.app.entity.CarService;
import com.app.entity.Cars;

public interface CarServiceService {
	
	public List<CarService> findAllCarService();
	public CarService findCarServiceById(int theId);
	public void saveCarService(CarService theCarService);
	public void deleteCarServiceById(int theId);	


}
