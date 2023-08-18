package com.app.service;

import java.util.List;

import com.app.entity.AppReview;

public interface AppReviewService {

	public List<AppReview> findAllAppReview();
	public AppReview findAppReviewById(int theId);
	public void saveAppReview(AppReview theAppReview);
	public void deleteAppReviewById(int theId);
}
