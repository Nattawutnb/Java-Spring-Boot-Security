package com.company.repository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.company.model.Employees;



@Repository
public class EmployeesRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	

	public Map<String, Object> getCountAdd(){
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.group("address").count().as("count"));
		return mongoTemplate.aggregate(aggregation, "employees", Employees.class).getRawResults();
	}
	
	public List<Employees> getAllEmp(){
		return mongoTemplate.findAll(Employees.class);
	}
	
	public List<Employees> getByName(String name){
		Query query = new Query(Criteria.where("name").regex("^"+name));
		return mongoTemplate.find(query, Employees.class);
	}
	
	public Employees saveEmp(Employees emp) {
		return mongoTemplate.save(emp);
	}
	
	public void deleteById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.remove(query, Employees.class);
	}
	
	public Employees updateEmp(Employees employees) {
		mongoTemplate.save(employees);
		return employees;
	}
	
	public void updateEmpById(Employees employees, String id) {
		Criteria criteria = Criteria.where("id").is(id);
		Query query = new Query(criteria);
		Update update = new Update();
		employees.setId(id);
		update.set("name", employees.getName());
		update.set("salary", employees.getSalary());
		update.set("address", employees.getAddress());
		update.set("department_id", employees.getDepartment_id());
		mongoTemplate.updateMulti(query, update, Employees.class);
		
	}
}
