package com.company.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.company.model.Departments;



@Repository
public class DepartmentRepository {
	
	@Autowired 
	MongoTemplate mongoTemplate;
	
	public List<Departments> getAll(){
		return mongoTemplate.findAll(Departments.class);
	}
	
	public Departments saveDpm(Departments dpm) {
		return mongoTemplate.save(dpm);
	}
	
	public void deleteById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.remove(query, Departments.class);
	}
	
	public void updateDpmById(Departments departments, String _id) {
		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);
		Update update = new Update();
		departments.set_id(_id);
		update.set("id", departments.getId());
		update.set("name", departments.getName());
		mongoTemplate.updateMulti(query, update, Departments.class);
		
	}
	
	
	

}
