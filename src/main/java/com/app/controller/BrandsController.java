package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BrandsRepository;
import com.app.entity.Brands;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class BrandsController {

	@Autowired
	private BrandsRepository brandsRepository;

	public BrandsController(BrandsRepository brandsRepository) {
		super();
		this.brandsRepository = brandsRepository;
	}
	
	@GetMapping("/cars/brands")
	public List<Brands> getAllBrands()
	{
		return brandsRepository.findAll();
	}
}
