package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
