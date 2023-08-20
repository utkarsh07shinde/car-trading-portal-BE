package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Cars;
import com.app.service.CarsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CarsController {

	private CarsService carsService;

	public CarsController(CarsService carsService) {
		super();
		this.carsService = carsService;
	}
	
	@GetMapping("/cars/{city}")
	public List<Cars> getCarsByCity(@PathVariable String city)
	{
		//return carsService.searchCarsByCity(city);
		return carsService.findAllCars();
	}
	
	@GetMapping("/cars")
	public List<Cars> getAllCars()
	{
		return carsService.findAllCars();
	}
	
}
