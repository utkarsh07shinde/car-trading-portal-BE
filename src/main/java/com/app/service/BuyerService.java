package com.app.service;

import java.util.List;

import com.app.entity.Admin;
import com.app.entity.Buyer;

public interface BuyerService {

	public List<Buyer> findAllBuyer();
	public Buyer findBuyerById(int theId);
	public void saveBuyer(Buyer theBuyer);
	public void deleteBuyerById(int theId);
}
