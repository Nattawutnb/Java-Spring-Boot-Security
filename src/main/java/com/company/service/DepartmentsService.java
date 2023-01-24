package com.company.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Departments;
import com.company.repository.DepartmentRepository;

@Service
public class DepartmentsService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Departments> getAll(){
		return departmentRepository.getAll();
	}
	
	public Departments saveDpm(Departments dpm) {
		return departmentRepository.saveDpm(dpm);
	}
	
	public void deleteById(String id) {
		departmentRepository.deleteById(id);	
	}
	
	public void updateDpmById(Departments departments, String _id) {
		departmentRepository.updateDpmById(departments, _id);
		
	}
	


}
