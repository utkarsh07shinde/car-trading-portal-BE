package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BuyerRepository;
import com.app.dao.UserRepository;
import com.app.entity.Buyer;
import com.app.entity.Seller;
import com.app.entity.User;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class BuyerController {

	@Autowired
	private BuyerRepository buyerRepository; 
	@Autowired
	private UserRepository userRepository; 
	
	
	@GetMapping("/cars/buyer")
	public List<Buyer> findBuyer()
	{
		return buyerRepository.findAll();
	}
	
	@PostMapping("/cars/buyerRegister")
	public String addBuyer(@RequestBody Buyer theBuyer)
	{
		int userId=userRepository.findByemail(theBuyer.getUserId().getEmail());
		User user =new User();
		user.setUser_id(userId);
		theBuyer.setUserId(user);
		buyerRepository.save(theBuyer);
		return "Buyer added succesfully";
	}
}
