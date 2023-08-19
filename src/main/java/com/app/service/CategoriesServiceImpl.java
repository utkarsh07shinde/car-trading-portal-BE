package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CarService;
import com.app.entity.Categories;
import com.app.dao.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	
	private CategoriesRepository categoriesRepository;

	@Autowired
	public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
		super();
		this.categoriesRepository = categoriesRepository;
	}

	@Override
	public List<Categories> findAllCategories() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll()  ;
	}

	@Override
	public Categories findCategoriesById(int theId) {
		// TODO Auto-generated method stub
		Optional<Categories> ca= categoriesRepository.findById(theId)  ;
		Categories theCategories=ca.get();
		return theCategories;	}

	@Override
	public void saveCategories(Categories theCategories) {
		// TODO Auto-generated method stub
		categoriesRepository.save(theCategories);
		
	}

	@Override
	public void deleteCategoriesById(int theId) {
		// TODO Auto-generated method stub
		categoriesRepository.deleteById(theId);
		
	}

}
