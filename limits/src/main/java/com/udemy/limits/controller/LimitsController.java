package com.udemy.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.limits.beans.Limits;
import com.udemy.limits.configuration.ConfigurationClass;

@RestController
public class LimitsController {
	
	@Autowired
	private ConfigurationClass conf;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(conf.getMinimum(), conf.getMaximum());
	}

}
