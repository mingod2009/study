package com.nie.microservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nie.microservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
