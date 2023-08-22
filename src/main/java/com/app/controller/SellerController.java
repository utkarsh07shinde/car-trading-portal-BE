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
import com.app.entity.User;
import com.app.service.SellerService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class SellerController {

	private SellerService sellerService;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/cars/sellerRegister")
	public String addSeller(@RequestBody Seller theSeller)
	{
		System.out.println(theSeller.toString());
		int userId=userRepository.findByemail(theSeller.getUser_id().getEmail());
		System.out.println("UserId="+userId);
		User user =new User();
		user.setUser_id(userId);
		System.out.println("USER ID="+user.getUser_id());
		theSeller.setUser_id(user);
		System.out.println(theSeller.toString());
		//sellerService.saveSeller(theSeller);
		sellerRepository.save(theSeller);
		return "seller added succesfully";
	}
}
