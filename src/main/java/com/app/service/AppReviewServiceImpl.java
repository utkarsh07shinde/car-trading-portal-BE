package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppReviewRepository;
import com.app.entity.AppReview;

@Service
public class AppReviewServiceImpl implements AppReviewService {

	private AppReviewRepository appReviewRepository; 
	
	
	@Autowired
	public AppReviewServiceImpl(AppReviewRepository appReviewRepository) {
		super();
		this.appReviewRepository = appReviewRepository;
	}

	@Override
	public List<AppReview> findAllAppReview() {
		// TODO Auto-generated method stub
		return appReviewRepository.findAll();
	}

	@Override
	public AppReview findAppReviewById(int theId) {
		// TODO Auto-generated method stub
		Optional<AppReview> ar= appReviewRepository.findById(theId);
		AppReview theAppReview=ar.get();
		return theAppReview;
		
	}

	@Override
	public void saveAppReview(AppReview theAppReview) {
		// TODO Auto-generated method stub
		appReviewRepository.save(theAppReview);
		
	}

	@Override
	public void deleteAppReviewById(int theId) {
		// TODO Auto-generated method stub
		appReviewRepository.deleteById(theId);
	}

}
