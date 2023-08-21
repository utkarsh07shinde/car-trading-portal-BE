package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BrandsRepository;
import com.app.entity.Brands;
import com.app.entity.Cars;
import com.app.service.CarsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CarsController {

	private CarsService carsService;
	
	@Autowired
	private BrandsRepository brandsRepository; 

	public CarsController(CarsService carsService) {
		super();
		this.carsService = carsService;
	}
	
	@GetMapping("/cars/brand/{brandName}")
	public List<Cars> getCarsByBrand(@PathVariable String brandName)
	{
		int brandId = brandsRepository.findByBrandName(brandName);
		System.out.println(brandId);
	   //return carsService.findCarById(brandId);
		Brands brand = new Brands();
		brand.setBrandId(brandId);
		return carsService.findCarsByBrandId(brand);
		//return carsService.findAllCars();
	}
	
	@GetMapping("/cars/city/{city}")
	public List<Cars> getCarsByCity(@PathVariable String city)
	{
		return carsService.findCarsByCity(city);
	}
	
	@GetMapping("/cars")
	public List<Cars> getAllCars()
	{
		return carsService.findAllCars();
	}
	
}
