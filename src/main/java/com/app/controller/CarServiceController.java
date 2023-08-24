package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CarServiceRepository;
import com.app.dao.CarsRepository;
import com.app.entity.CarService;
import com.app.entity.Cars;
import com.app.service.CarServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CarServiceController {

	private CarServiceService  carServiceService;
	
	@Autowired
	private CarsRepository carsRepository;
	
	@Autowired
	private CarServiceRepository carServiceRepository;
	
	@GetMapping("/cars/carservice")
	public List<CarService> getAllcarService()
	{
	//	return carServiceService.findAllCarService();
		return carServiceRepository.findAll();
		
	}
	
	@GetMapping("cars/service/{carId}")
	public List<CarService> getCarServices(@PathVariable int carId)
	{
		//System.out.println(carService.toString());
		Cars cars=new Cars();
		cars.setCar_id(carId);
		
		return carServiceRepository.findBycar(cars);
	}
	
	@PostMapping("cars/service/addService")
	public String addServices(@RequestBody CarService theCarService)
	{
		System.out.println(theCarService.toString());
		System.out.println(theCarService.getCar().getCar_id());
		//theCarService.getCar().setCar_id(theCarService.getCar().getCar_id());
		//List<CarService> carService=(List<CarService>) new CarService();
		carServiceRepository.save(theCarService);
		return "Car added succesfully";
		
	}
}
