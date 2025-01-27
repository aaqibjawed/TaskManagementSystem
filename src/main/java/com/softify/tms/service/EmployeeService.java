package com.softify.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softify.tms.entity.Employee;
import com.softify.tms.repository.EmployeeRepo;

@Service
public class EmployeeService implements UserDetailsService{
	@Autowired
	EmployeeRepo employeeRepo;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}
	public Employee getById(String id) {
		return employeeRepo.findById(id).orElse(null);
	}
	public Employee registerEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }
	public void delete(String id) {
		employeeRepo.deleteById(id);
	}
	
	@Override
    public UserDetails loadUserByUsername(String Id) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findById(Id)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return org.springframework.security.core.userdetails.User.builder()
            .username(employee.getId())
            .password(employee.getPassword())
            .roles(employee.getRole())
            .build();
    }
	
}
