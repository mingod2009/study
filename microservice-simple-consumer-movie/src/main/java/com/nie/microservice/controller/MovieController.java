package com.nie.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nie.microservice.entity.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://localhost:8088/" + id,  User.class);
	}
}
