package com.app.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appreview")
public class AppReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reviewId")
	private int reviewId; 
	@Column(name="rating")
	private int rating; 
	@Column(name="reviewText")
	private String reviewText ;
	@Column(name="reviewDate")
	private LocalDateTime reviewDate;
	public AppReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppReview(int reviewId, int rating, String reviewText, LocalDateTime reviewDate) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.reviewDate = reviewDate;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public LocalDateTime getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDateTime now) {
		this.reviewDate = now;
	}
	
	
}
