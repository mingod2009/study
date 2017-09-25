package com.nie.microservice.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nie.microservice.dao.UserRepository;
import com.nie.microservice.entity.User;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			UserDetails user = (UserDetails) principal;
			Collection<? extends GrantedAuthority> collection = user.getAuthorities();
			
			for (GrantedAuthority c : collection) {
				UserController.logger.info("当前是用户 {}， 角色是{}", user.getUsername(), c.getAuthority());
			}
		} else {
			
		}
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}
}
