package com.app.service;

import java.util.List;

import com.app.Entity.Cars;
import com.app.Entity.Categories;

public interface CategoriesService {

	public List<Categories> findAllCategories();
	public Categories findCategoriesById(int theId);
	public void saveCategories(Categories theCategories);
	public void deleteCategoriesById(int theId);	
}
