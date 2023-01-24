package com.company.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Employees;
import com.company.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

	@Autowired
	EmployeesService employeesService;

	@GetMapping("/groupAdd")
	public Map<String, Object> getCountAdd() {
		return employeesService.getCountAdd();
	}

	@GetMapping("findAll")
	public List<Employees> getAllEmp() {
		return employeesService.getAllEmp();
	}

	@GetMapping("/name")
	public List<Employees> getByName(@PathParam("name") String name) {
		return employeesService.getByName(name);
	}

	@PostMapping("/addemp")
	public Employees saveEmp(@RequestBody Employees emp) {
		return employeesService.saveEmp(emp);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		employeesService.deleteById(id);
		return id;

	}
	
	@PutMapping("/update")
	public Employees updateEmp(@RequestBody Employees employees) {
		return employeesService.updateEmp(employees);

	}

	@PutMapping("/update/{id}")
	public Employees updateEmpById(@RequestBody Employees employees,@PathVariable String id) {
		employeesService.updateEmpById(employees, id);
		return employees;
	}

}
