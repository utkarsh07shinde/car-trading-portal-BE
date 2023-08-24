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
	
	
	@PostMapping("/cars/registerCar")
	public String addCars(@RequestBody Cars theCar)
	{
		//String brandName= brandsRepository.findBrandName(theCar.getBrandId().getBrandName());
		//System.out.println("BrandName="+brandName);
		if(brandsRepository.findBrandName(theCar.getBrandId().getBrandName())==null)
		{
			brandsRepository.save(theCar.getBrandId());
		}
		if(categoriesRepository.findcategoryName(theCar.getCategoryId().getCategoryName())==null)
		{
			 categoriesRepository.save(theCar.getCategoryId());
		}
		
		int brandId = brandsRepository.findByBrandName(theCar.getBrandId().getBrandName());
		int categoryId= categoriesRepository.findByCategoryName(theCar.getCategoryId().getCategoryName());
		int userId=userRepository.findByemail(theCar.getSellerId().getUser_id().getEmail());
		int sellerId=sellerRepository.findByemail(theCar.getSellerId().getEmail());
		System.out.println("Seller id="+sellerId);
		User user= new User();
		user.setUser_id(userId);
		
		theCar.getBrandId().setBrandId(brandId);
		theCar.getCategoryId().setCategoryId(categoryId);
		theCar.getSellerId().setUser_id(user);;
		theCar.getSellerId().setSellerId(sellerId);
		theCar.setCar_id(0);
		carsService.saveCar(theCar);
		return "Car added succesfully";
	}
	
}
