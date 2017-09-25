package com.nie.consumer.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nie.consumer.service.RefactorHelloService;
import com.nie.provider.api.dto.User;
@Component
@RequestMapping("/fallback")
public class HelloServiceFallback implements RefactorHelloService{

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "error2";
	}

	@Override
	public User hello(String name, Integer age) {
		// TODO Auto-generated method stub
		return new User("未知2", 0);
	}

	@Override
	public String hello(User user) {
		// TODO Auto-generated method stub
		return "error2";
	}

	
}
