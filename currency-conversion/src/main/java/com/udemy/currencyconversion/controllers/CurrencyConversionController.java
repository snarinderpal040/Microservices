package com.udemy.currencyconversion.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.currencyconversion.beans.CurrencyConversion;
import com.udemy.currencyconversion.service.CurrencyConvertorService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConvertorService service;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		return new ResponseEntity<CurrencyConversion>(service.convert(from, to, quantity), HttpStatus.OK);
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> convertCurrencyfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		return new ResponseEntity<CurrencyConversion>(service.convertFeign(from, to, quantity), HttpStatus.OK);
	}

}
