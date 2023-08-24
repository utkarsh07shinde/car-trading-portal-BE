package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Integer> {

	@Query("select b.brandId FROM Brands as b WHERE b.brandName=:brandName")
	public int findByBrandName(String brandName);
	
	@Query("select b.brandName from Brands as b where b.brandName=:brandName")
	public String findBrandName(String brandName);
}
