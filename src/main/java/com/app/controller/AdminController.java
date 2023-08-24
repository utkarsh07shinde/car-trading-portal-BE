package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.AdminRepository;
import com.app.dao.UserRepository;
import com.app.entity.Admin;
import com.app.entity.Buyer;
import com.app.entity.User;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/cars/admin")
	public List<Admin> findAdmin()
	{
		return adminRepository.findAll();
	}
	
	@PostMapping("/cars/adminRegister")
	public String addBuyer(@RequestBody Admin theAdmin)
	{
		System.out.println(theAdmin.toString());
		int userId=userRepository.findByemail(theAdmin.getUserId().getEmail());
		System.out.println(userId);
		User user =new User();
		user.setUser_id(userId);
		theAdmin.setUserId(user);
		System.out.println(user.toString());
		//buyerRepository.save(theBuyer);
		adminRepository.save(theAdmin);
		return "admin added succesfully";
	}
}
