package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Carts;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Integer> {

}
