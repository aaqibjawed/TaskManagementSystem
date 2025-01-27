package com.softify.tms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.softify.tms.entity.Dashboard;
import com.softify.tms.entity.Employee;
import com.softify.tms.entity.Review;
import com.softify.tms.entity.Task;
import com.softify.tms.repository.TaskRepo;
import com.softify.tms.service.DashboardService;
import com.softify.tms.service.EmployeeService;
import com.softify.tms.service.ReviewService;
import com.softify.tms.service.TaskService;

@Controller
public class MainController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private DashboardService dashboardService;
	/*
	 * @Autowired private TaskService reviewService;
	 */

	@GetMapping("/dashboard")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String empId = authentication.getName();
		Employee e = employeeService.getById(empId);
		model.addAttribute("role", e.getRole());
		List<Dashboard> dashboards = dashboardService.getDashboard();
		model.addAttribute("dashboardData", dashboards);
		for(Dashboard data: dashboards)
			System.out.println(data.toString());
		return "Dashboard";
	}
	@GetMapping("/registration")
	public String registration() {
		return "Registration";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/task")
	public String task(Model model) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String username = authentication.getName(); // Get the logged-in username
		 model.addAttribute("empId", username); // Pass userId to Thymeleaf 
		 model.addAttribute("taskId", null);
		return "Task";
	}
	@GetMapping("/task/history")
	public String taskHistory(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String empId = authentication.getName();
		Employee e = employeeService.getById(empId);
		List<Dashboard> dashboards = dashboardService.getDashboardById(empId);
		model.addAttribute("role", e.getRole());
		model.addAttribute("empId", empId);
		model.addAttribute("dashboardData", dashboards);
		return "History";
	}
	@GetMapping("/task/history/{empId}")
	public String taskHistory(@PathVariable(name="empId") String empId, Model model) {
		Employee e = employeeService.getById(empId);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Employee loggedInE = employeeService.getById(authentication.getName());
		List<Dashboard> dashboards = dashboardService.getDashboardById(empId);
		model.addAttribute("role", loggedInE.getId());
		model.addAttribute("dashboardData", dashboards);
		return "History";
	}
	@GetMapping("/task/{taskId}")
	public String updateTask(@PathVariable(name = "taskId") Long taskId, Model model) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 model.addAttribute("empId", authentication.getName());
		 Task task = taskService.getTask(taskId);
		 model.addAttribute("task", task); // Pass userId to Thymeleaf 
		return "Task";
	}
	@GetMapping("/review/{taskId}")
	public String review(@PathVariable(name = "taskId") Long taskId, Model model) {
		  Task task = taskService.getTask(taskId); 
		  if(task == null) {
			  System.out.println("Task Not found"); 
		  } else { 
			  Employee e = employeeService.getById(task.getEmpId()); 
			  Review review = reviewService.getReviewByTaskId(taskId); 
			  model.addAttribute("taskId", taskId); 
			  model.addAttribute("name", e.getName()); 
			  model.addAttribute("task", task.getTask());
			  model.addAttribute("review", review);
		  }
		  return "Review";  
	}

	@PostMapping("/registration")
	public String register(@ModelAttribute("employee") Employee e, Model model) {
		try {
			if(employeeService.registerEmployee(e) != null)
				return "redirect:/dashboard";
			else {
				model.addAttribute("error", "Registration failed. Please try again.");
				return "Registration";
			}
		}
		catch(Exception ex) {
			model.addAttribute("error", "Registration failed. Please try again.");
			return "Registration";
		}
	}
	
	@PostMapping("/addTask") 
	public String add(@ModelAttribute("t") Task task, Model model) { 
		try {
			if(taskService.saveTask(task) == null) {
				System.out.println("Task not saved"); 
				return "Task"; 
			} 
			else { 
				return "redirect:/dashboard"; 
			}

		} catch (Exception e) { // TODO: handle exception
			System.out.println("Some exception occured"); 
			return "Task"; 
		} 
	}
	@PostMapping("/updateTask/{taskId}") 
	public String updateTask(@PathVariable(name="taskId") Long taskId, @ModelAttribute("taskE") Task task, Model model) { 
		try {
			task.setTaskId(taskId);
			if(taskService.saveTask(task) == null) {
				System.out.println("Task not saved"); 
				return "redirect:/task"; 
			} 
			else { 
				return "redirect:/dashboard"; 
			}

		} catch (Exception e) { // TODO: handle exception
			System.out.println("Some exception occured"); 
			return "Task"; 
		} 
	}
	@PostMapping("/review/{taskId}") 
	public String reviewTask(@PathVariable(name = "taskId") Long taskId, @ModelAttribute("review") Review review, Model model) { 
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Task task = taskService.getTask(taskId);
			review.setTaskId(taskId);
			review.setEmpId(task.getEmpId());
			review.setReviewerId(authentication.getName());
			review.setReviewDate(LocalDateTime.now());
			System.out.println(review.toString());

			if(reviewService.existsByTaskId(taskId)) {
				review.setReviewId(reviewService.getReviewByTaskId(taskId).getReviewId());
			}
			System.out.println(review.toString());
			if(reviewService.saveReview(review) == null) {
				System.out.println("review not saved"); 
				return "redirect:/review/"+taskId; 
			} 
			else { 
				return "redirect:/dashboard"; 
			}

		} catch (Exception e) { // TODO: handle exception
			System.out.println("Some exception occured"); 
			return "Review"; 
		} 
	}
	 

}
