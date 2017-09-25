package com.nie.provider.controller;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nie.provider.entity.User;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Value("${book.name}")
	private String bookName;
	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.desc}")
	private String bookDesc;
	@Value("${com.didispace.blog.value}")
	private String randomStr;
	@Value("${com.didispace.blog.number}")
	private String randomInt;
	@Value("${com.didispace.blog.bignumber}")
	private String randomBig;
	@Value("${com.didispace.blog.test1}")
	private String randomT1;
	@Value("${com.didispace.blog.test2}")
	private String randomT2;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/hello")
	public String index() throws InterruptedException {
		
		ServiceInstance instance = client.getLocalServiceInstance();
		
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime: "+ sleepTime);
		//Thread.sleep(sleepTime);
		String result = "";
		result += "{bookname:" +bookName + ",\n" +
		            "bookAuthor:" + bookAuthor +",\n" +
				    "bookDesc:" + bookDesc + ",\n" +
		            "randomStr:" + randomStr + ",\n" +
				    "randomInt:" + randomInt + ",\n" +
		            "randomBig:" + randomBig + ",\n" +
				    "randomT1: "+ randomT1 + ",\n" +
		            "randomT2:" + randomT2 + ",\n";
		
		counterService.increment("nie.hello.count");

		logger.info("/hello, host: " + instance.getHost() + ", service_id : " + instance.getServiceId());
		
		return result;
	}
	@RequestMapping(value="/hello1", method=RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		return new User(name, age);
	}
	@RequestMapping(value="hello3", method=RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello " + user.getName() + ", " +user.getAge();
	}
}
