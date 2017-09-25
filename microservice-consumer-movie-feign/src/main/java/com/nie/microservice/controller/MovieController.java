package com.nie.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nie.microservice.entity.User;
import com.nie.microservice.service.UserFeignClient;

@RestController
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
		
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo() {
		return this.discoveryClient.getInstances("microservice-provider-user");
	}
	@GetMapping("/log-instance")
	public String logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		MovieController.LOGGER.info("{}:{}:{}", 
				serviceInstance.getServiceId(),
				serviceInstance.getHost(),
				serviceInstance.getPort());
		return "" + serviceInstance.getServiceId() + ": " +
				serviceInstance.getHost() + ": " +
				serviceInstance.getPort();
	}
}
