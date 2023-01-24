package com.company.repository;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;
import com.company.model.Employees;

@Repository
public class DataDepartmentRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public Map<String, Object> getName(){
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.lookup("departments", "department_id", "id", "DataCompany"));
		return mongoTemplate.aggregate(aggregation, "employees", Employees.class ).getRawResults();
	}
	
	}
	
	


