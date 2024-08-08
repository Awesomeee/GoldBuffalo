package com.goldbuffalo.springapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	PersonRepository repository;
	
	@GetMapping(path = "/hello")
	public String hello() {
		Employee savedEmployee = repository.findById(1);
		System.out.println("hello");
		System.out.println(savedEmployee.getId());
		System.out.println(savedEmployee.getName());
		
		return "hello";
	}

}
