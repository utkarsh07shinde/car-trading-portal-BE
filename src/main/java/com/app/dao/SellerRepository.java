package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	@Query("select s.email FROM Seller as s WHERE s.email=:email")
	public String getByemail(String email);
	@Query("select s.sellerId FROM Seller as s WHERE s.email=:email")
	public int findByemail(String email);
}
