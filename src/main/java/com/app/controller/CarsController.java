package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BrandsRepository;
import com.app.dao.CategoriesRepository;
import com.app.dao.SellerRepository;
import com.app.dao.UserRepository;
import com.app.entity.Brands;
import com.app.entity.Cars;
import com.app.entity.Seller;
import com.app.entity.User;
import com.app.service.CarsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CarsController {

	private CarsService carsService;
	
	@Autowired
	private BrandsRepository brandsRepository; 
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerRepository sellerRepository; 

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
	
	@PostMapping("/cars/sell")
	public String addCars(@RequestBody Cars theCar)
	{
		System.out.println(theCar.getBrandId().getBrandName());
		int brandId = brandsRepository.findByBrandName(theCar.getBrandId().getBrandName());
		//System.out.println("UserID="+brandId);
		
		int categoryId= categoriesRepository.findByCategoryName(theCar.getCategoryId().getCategoryName());
	    
	   
		System.out.println(theCar.getSellerId().toString());
	//	System.out.println(theCar.getSellerId().getUser_id().toString());
		int userId=userRepository.findByemail(theCar.getSellerId().getUser_id().getEmail());
		System.out.println(userId);
	//	int userId=userRepository.findByemail(theCar.getSellerId().getUser_id().getEmail());
		//System.out.println("UserID="+userId);
		
		theCar.getBrandId().setBrandId(brandId);
		theCar.getCategoryId().setCategoryId(categoryId);
		
		System.out.println(categoryId);
		User user= new User();
		user.setUser_id(userId);
		theCar.getSellerId().setUser_id(user);;
	//	theCar.getSellerId().getUser_id().setUser_id(userId);
		theCar.setCar_id(0);
		carsService.saveCar(theCar);
		return "Car added succesfully";
	}
	
}
