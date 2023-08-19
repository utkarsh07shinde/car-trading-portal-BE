package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
