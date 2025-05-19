package com.softify.tms.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FilterHistory {
	String empName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate endDate;
	String taskStatus;
	String reviewStatus;
	public FilterHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterHistory(String empName, LocalDate startDate, LocalDate endDate, String taskStatus,
			String reviewStatus) {
		super();
		this.empName = empName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.taskStatus = taskStatus;
		this.reviewStatus = reviewStatus;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Override
	public String toString() {
		return "FilterHistory [empName=" + empName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", taskStatus=" + taskStatus + ", reviewStatus=" + reviewStatus + "]";
	}
	
	
	
	
}
