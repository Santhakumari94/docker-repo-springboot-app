package com.myapp.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.employee.entity.Employee;
import com.myapp.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping("/all-employees")
	public String lisEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "list_login_employees";
	}

	@GetMapping("/login-employee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "login";
	}

	@PostMapping("/all-employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/all-employees";
	}

}
