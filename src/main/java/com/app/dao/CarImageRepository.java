package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CarImage;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Integer>{

}
