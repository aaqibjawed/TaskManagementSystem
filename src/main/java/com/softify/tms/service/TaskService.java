package com.softify.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softify.tms.entity.Task;
import com.softify.tms.repository.TaskRepo;

@Service
public class TaskService {
	@Autowired
	TaskRepo taskRepo;
	public Task saveTask(Task task) {
		return taskRepo.save(task);
	}
	public Task getTask(Long taskId) {
		return taskRepo.findById(taskId).orElse(null);
	}
}
