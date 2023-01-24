package com.company.model;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public class Departments {
	
	@Id
	private String _id;
	private String id;
	private String name;
}
