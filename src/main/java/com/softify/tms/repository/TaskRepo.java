package com.softify.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softify.tms.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{
	public List<Task> findByEmpId(String taskId);
}
