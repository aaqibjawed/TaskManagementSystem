package com.softify.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softify.tms.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
	
}
