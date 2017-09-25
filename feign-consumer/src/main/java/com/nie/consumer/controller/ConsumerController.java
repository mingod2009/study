package com.nie.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nie.consumer.dto.User;
import com.nie.consumer.service.HelloService;
import com.nie.consumer.service.RefactorHelloService;

@RestController
public class ConsumerController {
	
	
	@Autowired
	HelloService helloService;
	@Autowired
	RefactorHelloService refactorHelloService;
	
	@RequestMapping(value="/feign-consumer", method=RequestMethod.GET)
	public String helloConsumer() {
		
		String result = helloService.hello();
		
		return result;
	}
	
	@RequestMapping(value="/feign-consumer2", method=RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("DIDI")).append("\n");
		sb.append(helloService.hello("DIDI", 30)).append("\n");
		sb.append(helloService.hello(new User("DIDI", 30))).append("\n");
		return sb.toString();
	}
	@RequestMapping(value="/feign-consumer3", method=RequestMethod.GET)
	public String helloConsumer3() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactorHelloService.hello("MIMI")).append("\n");
		sb.append(refactorHelloService.hello("MIMI", 20)).append("\n");
		sb.append(refactorHelloService.hello(new com.nie.provider.api.dto.User("MIMI", 20))).append("\n");
		return sb.toString();
	}
}
