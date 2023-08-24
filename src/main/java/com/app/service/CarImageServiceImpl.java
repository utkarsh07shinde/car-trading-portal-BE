package com.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CarImageRepository;
import com.app.entity.AppReview;
import com.app.entity.CarImage;

@Service
public class CarImageServiceImpl implements CarImageService{

	private CarImageRepository carImageRepository; 
	
	
	@Autowired
	public CarImageServiceImpl(CarImageRepository carImageRepository) {
		super();
		this.carImageRepository = carImageRepository;
	}

	@Override
	public List<CarImage> findAllCarImage() {
		// TODO Auto-generated method stub
		return carImageRepository.findAll();
	}

	@Override
	public CarImage findCarImageById(int theId) {
		// TODO Auto-generated method stub
		Optional<CarImage> ci= carImageRepository.findById(theId);
		CarImage theCarImage=ci.get();
		return theCarImage;
	}

	@Override
	public void saveCarImage(CarImage theCarImage) {
		// TODO Auto-generated method stub
		carImageRepository.save(theCarImage);
	}

	@Override
	public void deleteCarImageById(int theId) {
		// TODO Auto-generated method stub
		carImageRepository.deleteById(theId);
	}

	@Override
	public InputStream getResouce(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String name=file.getOriginalFilename();
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name).substring(name.lastIndexOf("."));
		String filePath=path+File.separator+fileName1;
		File f= new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return fileName1;
	}

	
}
