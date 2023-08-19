package com.app.service;

import java.util.List;

import com.app.entity.Cars;
import com.app.entity.Seller;

public interface SellerService {
	
	public List<Seller> findAllSeller();
	public Seller findSellerById(int theId);
	public void saveSeller(Seller theSeller);
	public void deleteSellerById(int theId);	

}
