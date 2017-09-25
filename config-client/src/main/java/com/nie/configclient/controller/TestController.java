package com.nie.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Value("${from}")
	private String from;
	@Value("${zuul.routes.service-b.path}")
	private String zuul;
	
	@RequestMapping("/from")
	public String from() {
		return this.from;
	}
	@RequestMapping("/zuul")
	public String zuul() {
		return this.zuul;
	}
}
