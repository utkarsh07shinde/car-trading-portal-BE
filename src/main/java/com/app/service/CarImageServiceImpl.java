package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
