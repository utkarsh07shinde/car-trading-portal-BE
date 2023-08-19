package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CarService;
import com.app.entity.Seller;
import com.app.dao.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService{
	
	private SellerRepository sellerRepository;
	
	@Autowired
	public SellerServiceImpl(com.app.dao.SellerRepository sellerRepository) {
		super();
		sellerRepository = sellerRepository;
	}

	@Override
	public List<Seller> findAllSeller() {
		// TODO Auto-generated method stub
		return sellerRepository.findAll()  ;

			}

	@Override
	public Seller findSellerById(int theId) {
		// TODO Auto-generated method stub
		Optional<Seller> s= sellerRepository.findById(theId)  ;
		Seller theSeller=s.get();
		return theSeller;	}

	@Override
	public void saveSeller(Seller theSeller) {
		// TODO Auto-generated method stub
		sellerRepository.save(theSeller);

		
	}

	@Override
	public void deleteSellerById(int theId) {
		// TODO Auto-generated method stub
		sellerRepository.deleteById(theId);

		
	}

}
