package com.softify.tms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
