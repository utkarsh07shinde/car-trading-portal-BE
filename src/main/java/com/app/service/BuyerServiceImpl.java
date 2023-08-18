package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BuyerRepository;
import com.app.entity.Admin;
import com.app.entity.Buyer;

@Service
public class BuyerServiceImpl implements BuyerService{

	private BuyerRepository buyerRepository;
	
	
	@Autowired
	public BuyerServiceImpl(BuyerRepository buyerRepository) {
		super();
		this.buyerRepository = buyerRepository;
	}

	@Override
	public List<Buyer> findAllBuyer() {
		// TODO Auto-generated method stub
		return buyerRepository.findAll();
	}

	@Override
	public Buyer findBuyerById(int theId) {
		// TODO Auto-generated method stub
		Optional<Buyer> b= buyerRepository.findById(theId);
		Buyer theBuyer=b.get();
		return theBuyer;
	}

	@Override
	public void saveBuyer(Buyer theBuyer) {
		// TODO Auto-generated method stub
		buyerRepository.save(theBuyer);
	}

	@Override
	public void deleteBuyerById(int theId) {
		// TODO Auto-generated method stub
		buyerRepository.deleteById(theId);
	}

	
}
