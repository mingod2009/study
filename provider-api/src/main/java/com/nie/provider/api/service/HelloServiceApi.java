package com.nie.provider.api.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nie.provider.api.dto.User;

@RequestMapping("/refactor")
public interface HelloServiceApi {
	
	@RequestMapping(value="/hello4", method=RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	
	@RequestMapping(value="/hello5", method=RequestMethod.GET)
	User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping(value="/hello6", method=RequestMethod.POST)
	String hello(@RequestBody User user);
}