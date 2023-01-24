package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Departments;
import com.company.service.DepartmentsService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentsService departmentsService;
	
	@GetMapping("/findAll")
	public List<Departments> getAll(){
		return departmentsService.getAll();
	}
	
	@PostMapping("/adddpm")
	public Departments saveDpm(@RequestBody Departments dpm) {
		return departmentsService.saveDpm(dpm);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		departmentsService.deleteById(id);
		return id;
		
	}
	
	@PutMapping("/update/{_id}")
	public Departments updateDpmById(@RequestBody Departments departments,@PathVariable String _id) {
		departmentsService.updateDpmById(departments, _id);
		return departments;
		
		
	}

}
