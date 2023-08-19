package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.Cars;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{

}
