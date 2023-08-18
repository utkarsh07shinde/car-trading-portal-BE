package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Integer> {

}
