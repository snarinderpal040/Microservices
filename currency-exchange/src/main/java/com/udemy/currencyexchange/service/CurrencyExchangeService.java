package com.udemy.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.udemy.currencyexchange.beans.CurrencyExchange;
import com.udemy.currencyexchange.repositories.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repo;

	public CurrencyExchange findByFromAndTo(String from, String to) {
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException(String.format("unable to find the data from %s to %s", from, to));
		}
		String envInfo = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(envInfo);
		return currencyExchange;
	}
	
	
	
}
