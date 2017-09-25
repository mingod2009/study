package com.nie.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(methods={RequestMethod.GET,RequestMethod.POST})
public class MsaSampleApplication {
	@RequestMapping(name="HelloService", method=RequestMethod.GET, path="/hello")
	public String hello() {
		return "hello msa framework";
	}
	public static void main(String[] args) {
		SpringApplication.run(MsaSampleApplication.class, args);
	}
}
