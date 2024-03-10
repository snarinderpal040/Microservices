package com.udemy.currencyexchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.currencyexchange.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);
	
}
