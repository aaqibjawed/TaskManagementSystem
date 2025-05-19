package com.softify.tms.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softify.tms.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{
	public List<Task> findByEmpId(String taskId);
	public List<Task> findByTaskDateBetween(LocalDateTime dt1, LocalDateTime dt2);

	@Query(value = "SELECT * FROM public.task ORDER BY task_id ASC ", nativeQuery = true)
	List<Task> findByParams();

}

//@Query("SELECT * FROM Task t WHERE "
//+ "(:empId IS NULL OR t.empId = :empId) "
//+ "AND (:startDate IS NULL OR :endDate IS NULL OR t.taskDate BETWEEN :startDate AND :endDate) "
//+ "AND (:taskStatus IS NULL OR t.status = :taskStatus)")
//List<Task> findByParams(
//@Param("empId") String empId, 
//@Param("startDate") LocalDateTime startDate, 
//@Param("endDate") LocalDateTime endDate, 
//@Param("taskStatus") String taskStatus
//);
