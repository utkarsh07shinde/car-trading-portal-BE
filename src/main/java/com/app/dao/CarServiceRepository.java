package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.CarService;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Integer> {

}
