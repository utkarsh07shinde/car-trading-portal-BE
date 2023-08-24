package com.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Buyer;
import com.app.entity.CarImage;

public interface CarImageService {

	public List<CarImage> findAllCarImage();
	public CarImage findCarImageById(int theId);
	public void saveCarImage(CarImage theCarImage);
	public void deleteCarImageById(int theId);
	InputStream getResouce(String path,String fileName) throws FileNotFoundException;
	public String uploadImage(String path,MultipartFile file) throws IOException;
}
