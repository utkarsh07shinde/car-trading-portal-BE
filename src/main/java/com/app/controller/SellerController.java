package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.SellerRepository;
import com.app.dao.UserRepository;
import com.app.entity.Seller;
import com.app.service.SellerService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class SellerController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/Cars/sellerRegister")
	public String addSeller(@RequestBody Seller theSeller)
	{
		int userId=userRepository.findByemail(theSeller.getUser_id().getEmail());
		System.out.println(userId);
		return "seller added succesfully";
	}
}
