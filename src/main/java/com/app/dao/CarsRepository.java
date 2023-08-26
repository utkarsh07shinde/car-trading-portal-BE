package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Brands;
import com.app.entity.Cars;
@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{

	
	public List<Cars> getCarsByCity(String city);
	
	//@Query("select c.model FROM Cars as c WHERE c.brandId=:brandId ")
	public List<Cars> getCarsBybrandId(Brands brandId);
	
//	@Query("FROM Cars as c WHERE c.brandId=:brandId AND c.city=city ")
	public List<Cars> findByBrandIdAndCity(Brands brandId, String city);
	
	@Query("SELECT DISTINCT c.city FROM Cars c")
    List<String> findAllCities();
}
