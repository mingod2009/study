package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.MyBean;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class Example {
	
	@Autowired
	private MyBean bean;
	
	@RequestMapping("/")
	String home() {
		
		return bean.getName();
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(Example.class);
		//app.setAddCommandLineProperties(false);
		app.run(args);
	}

}
