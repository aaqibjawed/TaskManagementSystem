package com.softify.tms.entity;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long taskId;
    private String empId;
    private String reviewerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime reviewDate;
	String reviewStatus;
	String comments;
	String isCommentImplemented;
    
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String reviewStatus, String comments,
			String isCommentImplemented) {
		super();
		this.reviewStatus = reviewStatus;
		this.comments = comments;
		this.isCommentImplemented = isCommentImplemented;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIsCommentImplemented() {
		return isCommentImplemented;
	}

	public void setIsCommentImplemented(String isCommentImplemented) {
		this.isCommentImplemented = isCommentImplemented;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", empId=" + empId + ", reviewerId=" + reviewerId + ", reviewDate="
				+ reviewDate + ", reviewStatus=" + reviewStatus + ", comments=" + comments + ", isCommentImplemented="
				+ isCommentImplemented + "]";
	}
	
}
