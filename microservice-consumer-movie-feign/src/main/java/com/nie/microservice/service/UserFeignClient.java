package com.nie.microservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nie.microservice.config.FeignConfiguration;
import com.nie.microservice.entity.User;

import feign.Param;
import feign.RequestLine;
@FeignClient(name="microservice-provider-user", configuration=FeignConfiguration.class)
public interface UserFeignClient {

	//@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);
}
