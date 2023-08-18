package com.app.service;

import java.util.List;

import com.app.entity.Brands;

public interface BrandsService {

	public List<Brands> findAllBrands();
	public Brands findBrandsById(int theId);
	public void saveBrands(Brands theBrands);
	public void deleteBrandsById(int theId);
}
