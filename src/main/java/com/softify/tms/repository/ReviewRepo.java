package com.softify.tms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softify.tms.entity.Review;
import com.softify.tms.entity.Task;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{
	Optional<Review> findByTaskId(Long taskId);
	boolean existsByTaskId(Long taskId);
	List<Review> findByEmpId(String empId);
}
