package com.softify.tms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.softify.tms.entity.Dashboard;
import com.softify.tms.entity.Employee;
import com.softify.tms.entity.Review;
import com.softify.tms.entity.Task;
import com.softify.tms.repository.EmployeeRepo;
import com.softify.tms.repository.ReviewRepo;
import com.softify.tms.repository.TaskRepo;

@Service
public class DashboardService {
	@Autowired
	TaskRepo taskRepo;
	@Autowired
	ReviewRepo reviewRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Dashboard> getDashboard(){
		LocalDate date = LocalDate.now();
		LocalDateTime start = date.atStartOfDay();
		LocalDateTime end = date.atTime(23, 59, 59);
		List<Task> tasks = taskRepo.findByTaskDateBetween(start, end);
		List<Review> reviews = reviewRepo.findAll();
		List<Dashboard> dashboard = new ArrayList<>();
		for(Task task: tasks) {
			Employee e = employeeRepo.findById(task.getEmpId()).get();
			Review rev = reviews.stream().filter(r -> r.getTaskId()
					.equals(task.getTaskId()))
					.findFirst().
					orElse(null);
			if(rev != null) {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(),
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						rev.getReviewId(), 
						rev.getReviewerId(), 
						rev.getReviewDate(), 
						rev.getReviewStatus(), 
						rev.getComments(), 
						rev.getIsCommentImplemented()
				));
			}
			else {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(), 
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						null,
						null,
						null,
						null,
						null,
						null
				));
			}
		}
		return dashboard;
	}
	public List<Dashboard> getAllDashboard(){
		
		List<Task> tasks = taskRepo.findAll();
		List<Review> reviews = reviewRepo.findAll();
		List<Dashboard> dashboard = new ArrayList<>();
		for(Task task: tasks) {
			Employee e = employeeRepo.findById(task.getEmpId()).get();
			Review rev = reviews.stream().filter(r -> r.getTaskId()
					.equals(task.getTaskId()))
					.findFirst().
					orElse(null);
			if(rev != null) {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(),
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						rev.getReviewId(), 
						rev.getReviewerId(), 
						rev.getReviewDate(), 
						rev.getReviewStatus(), 
						rev.getComments(), 
						rev.getIsCommentImplemented()
				));
			}
			else {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(), 
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						null,
						null,
						null,
						null,
						null,
						null
				));
			}
		}
		return dashboard;
	}
	public List<Dashboard> getDashboardById(String empId){
		List<Task> tasks = taskRepo.findByEmpId(empId);
		List<Review> reviews = reviewRepo.findByEmpId(empId);
		List<Dashboard> dashboard = new ArrayList<>();
		for(Task task: tasks) {
			Employee e = employeeRepo.findById(task.getEmpId()).get();
			Review rev = reviews.stream().filter(r -> r.getTaskId()
					.equals(task.getTaskId()))
					.findFirst().
					orElse(null);
			if(rev != null) {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(),
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						rev.getReviewId(), 
						rev.getReviewerId(), 
						rev.getReviewDate(), 
						rev.getReviewStatus(), 
						rev.getComments(), 
						rev.getIsCommentImplemented()
				));
			}
			else {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(), 
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						null,
						null,
						null,
						null,
						null,
						null
				));
			}
		}
		return dashboard;
	}
	public List<Dashboard> getFilteredDashboard(String empId, String empName, LocalDate startDate, LocalDate endDate,
			String taskStatus, String reviewSatus){
		
		LocalDateTime startDateTime = startDate == null ? null : startDate.atStartOfDay();
		LocalDateTime endDateTime =  endDate == null ? null : endDate.atTime(LocalTime.MAX);
		List<Task> tasks = taskRepo.findByParams();
		List<Review> reviews = reviewRepo.findAll();
		List<Dashboard> dashboard = new ArrayList<>();
		for(Task task: tasks) {
			Employee e = employeeRepo.findById(task.getEmpId()).get();
			Review rev = reviews.stream().filter(r -> r.getTaskId()
					.equals(task.getTaskId()))
					.findFirst().
					orElse(null);
			if(rev != null) {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(),
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						rev.getReviewId(), 
						rev.getReviewerId(), 
						rev.getReviewDate(), 
						rev.getReviewStatus(), 
						rev.getComments(), 
						rev.getIsCommentImplemented()
				));
			}
			else {
				dashboard.add(new Dashboard(
						task.getTaskId(), 
						task.getEmpId(), 
						e.getName(),
						task.getTask(), 
						task.getDuration(), 
						task.getStatus(), 
						null,
						null,
						null,
						null,
						null,
						null
				));
			}
		}
		return dashboard;
	}
}
