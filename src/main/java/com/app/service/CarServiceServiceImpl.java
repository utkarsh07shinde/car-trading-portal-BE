package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CarService;
import com.app.dao.CarServiceRepository;
import com.app.entity.CarService;
import com.app.entity.Cars;
@Service
public class CarServiceServiceImpl implements CarServiceService {
	
	private CarServiceRepository carServiceRepository;
	
	
   @Autowired
	public CarServiceServiceImpl(CarServiceRepository carServiceRepository) {
		super();
		this.carServiceRepository = carServiceRepository;
	}

	@Override
	public List<CarService> findAllCarService() {
		// TODO Auto-generated method stub
		return carServiceRepository.findAll()  ;
	}

	@Override
	public CarService findCarServiceById(int theId) {
		// TODO Auto-generated method stub
		Optional<CarService> cs= carServiceRepository.findById(theId)  ;
		CarService theCarService=cs.get();
		return theCarService;
	}

	@Override
	public void saveCarService(CarService theCarService) {
		// TODO Auto-generated method stub
		carServiceRepository.save(theCarService);
		
	}

	@Override
	public void deleteCarServiceById(int theId) {
		// TODO Auto-generated method stub
		carServiceRepository.deleteById(theId);
	}

}
