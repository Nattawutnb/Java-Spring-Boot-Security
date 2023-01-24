package com.company.service;

import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import com.company.model.Departments;
import com.company.model.Employees;
import com.company.repository.DataDepartmentRepository;

@Service
public class DataDepartmentService {
	@Autowired
	DataDepartmentRepository dataDepartmentRepository;
	

	
	public Map<String, Object> getName(){
		return dataDepartmentRepository.getName();
	}
	

	 

}
