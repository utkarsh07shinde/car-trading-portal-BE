package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Brands;
import com.app.entity.Cars;

public interface CarsService {
	
	public List<Cars> findAllCars();
	public List<Cars> findCarsByCity(String city);
	public List<Cars> findCarsByBrandId(Brands theBrands);
	public Cars findCarById(int theId);
	public void saveCar(Cars theCars);
	public void deleteCarById(int theId);	

	public String uploadImage(String path,MultipartFile file) throws IOException;
}
