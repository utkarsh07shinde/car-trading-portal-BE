package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.BrandsRepository;
import com.app.dao.CarsRepository;
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
	private CarsRepository carsRepository;
	
	@Autowired
	private BrandsRepository brandsRepository; 
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerRepository sellerRepository; 
	
	@Value("${project.image}")
	private String path;

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
	
	@GetMapping("/cars/brandCity")
	//@PostMapping("/cars/brandCity")
	public List<Cars> getCarsByBrandCity(@RequestParam("brandName") String brandName,@RequestParam("city") String city )
	{
		System.out.println(brandName);
		System.out.println(city);
		int brandId = brandsRepository.findByBrandName(brandName);
		System.out.println(brandId);
	   //return carsService.findCarById(brandId);
		Brands brand = new Brands();
		brand.setBrandId(brandId);
		return carsRepository.findByBrandIdAndCity(brand, city) ;
	}
	
	@GetMapping("/cars/city")
	public List<String> getAllCity()
	{
		return carsRepository.findAllCities();
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
	
	@DeleteMapping("/cars/{carId}")
	public String deleteCar(@PathVariable int carId)
	{
		carsRepository.deleteById(carId);
		return carId+"  car deleted succesfully";
	}
	
	
	@PostMapping("/cars/registerCar")
	public String addCars(@RequestBody Cars theCar) throws IOException
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
		
	//	String checkSeller=sellerRepository.getByemail(theCar.getSellerId().getEmail());
		
		User user= new User();
		user.setUser_id(userId);
		
		theCar.getBrandId().setBrandId(brandId);
		theCar.getCategoryId().setCategoryId(categoryId);
		theCar.getSellerId().setUser_id(user);
		
		theCar.setCar_id(0);
		if(sellerRepository.getByemail(theCar.getSellerId().getEmail()) == null)
		{
			sellerRepository.save(theCar.getSellerId());
		}
		else {
			int sellerId=sellerRepository.findByemail(theCar.getSellerId().getEmail());
			System.out.println("Seller id="+sellerId);
			theCar.getSellerId().setSellerId(sellerId);
		}
		
		carsService.saveCar(theCar);
		return "Car added succesfully";
	}
	
	@PutMapping("/cars/updateCars")
	public String updateCars(@RequestBody Cars theCar)
	{
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
		
	//	String checkSeller=sellerRepository.getByemail(theCar.getSellerId().getEmail());
		
		User user= new User();
		user.setUser_id(userId);
		
		theCar.getBrandId().setBrandId(brandId);
		theCar.getCategoryId().setCategoryId(categoryId);
		theCar.getSellerId().setUser_id(user);
		
		theCar.setCar_id(0);
		if(sellerRepository.getByemail(theCar.getSellerId().getEmail()) == null)
		{
			sellerRepository.save(theCar.getSellerId());
		}
		else {
			int sellerId=sellerRepository.findByemail(theCar.getSellerId().getEmail());
			System.out.println("Seller id="+sellerId);
			theCar.getSellerId().setSellerId(sellerId);
		}
		
		carsService.saveCar(theCar);
		return "Car update succesfully";
	}
	
}
