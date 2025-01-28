package com.softify.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softify.tms.entity.Review;
import com.softify.tms.repository.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	ReviewRepo reviewRepo;
	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}
	public Review getReviewByTaskId(Long taskId) {
		return reviewRepo.findByTaskId(taskId).orElse(null);
	}
	public boolean existsByTaskId(Long taskId) {
		return reviewRepo.existsByTaskId(taskId);
	}
    @Transactional
	public void deleteByTaskId(Long taskId) {
		 reviewRepo.deleteByTaskId(taskId);
	}
}
