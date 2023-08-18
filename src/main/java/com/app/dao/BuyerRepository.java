package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

}
