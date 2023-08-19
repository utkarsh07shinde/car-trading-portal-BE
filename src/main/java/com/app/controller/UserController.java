package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	} 
	

	@PostMapping("/loginUser")
	public String submitUser(@RequestBody User user)
	{
		System.out.println(user.toString());
		User u = null;
		
		
			u= userService.validateUser(user.getEmail(),user.getPassword());

		System.out.println(u);
		
		if(u==null)
		{
			return "error utkarsh";
		}
		else
		{
			return "login-success";
		}
	}
	
}
