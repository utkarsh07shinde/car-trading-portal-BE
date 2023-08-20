package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Cars;
@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{

	@Query("select c.color from Cars as c where city=:city")
	public List<Cars> searchCarsByCity(String city);
}
