package com.company.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.model.Employees;
import com.company.repository.EmployeesRepository;


@Service
public class EmployeesService {
	
	@Autowired
	EmployeesRepository employeesRepository;

	
	
	public Map<String, Object> getCountAdd(){
		return employeesRepository.getCountAdd();
	}
	
	public List<Employees> getAllEmp(){
		return employeesRepository.getAllEmp();
	}
	
	public Employees saveEmp(Employees emp) {
		return employeesRepository.saveEmp(emp);
	}
	
	public List<Employees> getByName(String name){
		return employeesRepository.getByName(name);
		
	}
	public void deleteById(String id) {
		employeesRepository.deleteById(id);	
	}
	public Employees updateEmp(Employees employees) {
		return employeesRepository.updateEmp(employees);
		
	}
	public void updateEmpById(Employees employees, String id) {
		employeesRepository.updateEmpById(employees,id);
		
	}
	
}
