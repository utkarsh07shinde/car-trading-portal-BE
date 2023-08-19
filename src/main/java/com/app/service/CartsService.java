package com.app.service;

import java.util.List;

import com.app.entity.Cars;
import com.app.entity.Carts;

public interface CartsService {
	
	public List<Carts> findAllCarts();
	public Carts findCartsById(int theId);
	public void saveCarts(Carts theCarts);
	public void deleteCartsById(int theId);	

}
