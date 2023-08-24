package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.AppReviewRepository;
import com.app.entity.AppReview;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class AppReviewController {

	@Autowired
	private AppReviewRepository appReviewRepository;
	
	@GetMapping("/cars/appReview")
	public List<com.app.entity.AppReview> getAppReview()
	{
		return appReviewRepository.findAll();
		
	}
	
	@PostMapping("/cars/addReview")
	public AppReview addAppReview(@RequestBody AppReview appReview)
	{
		LocalDateTime now = LocalDateTime.now();  
		appReview.setReviewDate(now);
		return appReviewRepository.save(appReview);
		
	}
}
