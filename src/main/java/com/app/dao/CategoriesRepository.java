package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

	@Query("select c.categoryId FROM Categories as c WHERE c.categoryName=:categoryName")
	public int findByCategoryName(String categoryName);
}
