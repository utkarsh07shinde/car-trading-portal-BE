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

import com.app.dao.CartsRepository;
import com.app.entity.Buyer;
import com.app.entity.Cars;
import com.app.entity.Carts;
import com.app.service.CartsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CartsController {

	@Autowired
	private CartsService cartService;
	
	private CartsRepository cartsRepository;
	
    @PostMapping("/cars/addToCarts")
    public String addToCart(@RequestBody Carts cart) {
    	
  
         cartService.saveCarts(cart);
         return "carts added succesfully";
    }
    
    @GetMapping("/cars/carts/{buyerId}")
    public List<Carts> getCarts(@PathVariable int buyerId)
    {
    	Buyer buyer=new Buyer();
    	buyer.setBuyerId(buyerId);
    	return cartsRepository.getCartsBybuyerId(buyer);
    }
}
