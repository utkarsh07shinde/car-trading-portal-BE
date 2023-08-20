package com.app.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.app.entity.Buyer;
import com.app.entity.CarImage;

public interface CarImageService {

	public List<CarImage> findAllCarImage();
	public CarImage findCarImageById(int theId);
	public void saveCarImage(CarImage theCarImage);
	public void deleteCarImageById(int theId);
	InputStream getResouce(String path,String fileName) throws FileNotFoundException;
	
}
