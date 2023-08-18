package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.AppReview;

@Repository
public interface AppReviewRepository extends JpaRepository<AppReview, Integer>{

}
