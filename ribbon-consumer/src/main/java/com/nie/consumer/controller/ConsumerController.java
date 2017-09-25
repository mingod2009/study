package com.nie.consumer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nie.consumer.service.HelloService;

@RestController
public class ConsumerController {
	
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/ribbon-consumer", method=RequestMethod.GET)
	public String helloConsumer() {
		
		String result = helloService.helloService();
		
		return result;
	}
}
