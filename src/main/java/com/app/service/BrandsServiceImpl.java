package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BrandsRepository;

import com.app.entity.Brands;

@Service
public class BrandsServiceImpl implements BrandsService {

	private BrandsRepository brandsRepository;
	
	
	@Autowired
	public BrandsServiceImpl(BrandsRepository brandsRepository) {
		super();
		this.brandsRepository = brandsRepository;
	}

	@Override
	public List<Brands> findAllBrands() {
		// TODO Auto-generated method stub
		return brandsRepository.findAll();
	}

	@Override
	public Brands findBrandsById(int theId) {
		// TODO Auto-generated method stub
		Optional<Brands> br= brandsRepository.findById(theId);
		Brands theBrands=br.get();
		return theBrands;
	}

	@Override
	public void saveBrands(Brands theBrands) {
		// TODO Auto-generated method stub
		brandsRepository.save(theBrands);
	}

	@Override
	public void deleteBrandsById(int theId) {
		// TODO Auto-generated method stub
		brandsRepository.deleteById(theId);
	}

}
