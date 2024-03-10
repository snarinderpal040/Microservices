package com.udemy.currencyconversion.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {
	List<String> list = new ArrayList<>();	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/hello")
//	@Retry(name = "hello", fallbackMethod = "hardCodedResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
	public String greetings() {
		logger.info("greetings method is called");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class);
		return forEntity.getBody();
	}
	
	@PostMapping("/hello/{s}")
	public String greetingsPost(@PathVariable String s) {
		logger.info("greetings method is called");
		list.add(s);
		return "Inserted successfully";
	}
	
	public String hardCodedResponse(Exception ex) {
		return "fallback response";
	}
	
}
