package com.softify.tms.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Dashboard {
    private Long taskId;
    private String empId;
    private String empName;
    private String task;
    private Integer duration;
    private String status;
    private Long reviewId;
    private String reviewerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime reviewDate;
	String reviewStatus;
	String comments;
	String isCommentImplemented;
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dashboard(Long taskId, String empId, String empName, String task, Integer duration, String status, Long reviewId,
			String reviewerId, LocalDateTime reviewDate, String reviewStatus, String comments,
			String isCommentImplemented) {
		super();
		this.taskId = taskId;
		this.empId = empId;
		this.empName = empName;
		this.task = task;
		this.duration = duration;
		this.status = status;
		this.reviewId = reviewId;
		this.reviewerId = reviewerId;
		this.reviewDate = reviewDate;
		this.reviewStatus = reviewStatus;
		this.comments = comments;
		this.isCommentImplemented = isCommentImplemented;
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
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
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
		return "Dashboard [taskId=" + taskId + ", empId=" + empId + ", empName=" + empName + ", task=" + task
				+ ", duration=" + duration + ", status=" + status + ", reviewId=" + reviewId + ", reviewerId="
				+ reviewerId + ", reviewDate=" + reviewDate + ", reviewStatus=" + reviewStatus + ", comments="
				+ comments + ", isCommentImplemented=" + isCommentImplemented + "]";
	}
	
	
}
