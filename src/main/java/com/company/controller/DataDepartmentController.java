package com.company.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.service.DataDepartmentService;

@RestController
@RequestMapping("/data")
public class DataDepartmentController {
	
	@Autowired
	DataDepartmentService dataDepartmentService;
	

	@GetMapping("/company")
	public Map<String, Object> getName(){
		return dataDepartmentService.getName();
	}

}
