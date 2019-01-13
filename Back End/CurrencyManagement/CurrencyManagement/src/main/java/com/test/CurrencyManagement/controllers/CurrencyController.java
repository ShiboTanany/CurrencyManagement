package com.test.CurrencyManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.CurrencyManagement.entities.Currency;
import com.test.CurrencyManagement.entities.User;
import com.test.CurrencyManagement.services.CurrencyService;

@RestController
@RequestMapping("/api/Currencies")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@RequestMapping(path = "/currency/create", method = RequestMethod.POST)
	public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {
		Currency returnCurrency = null;
		if (currency != null)
			returnCurrency = currencyService.createCurrency(currency);
		ResponseEntity<Currency> response = null;
		if (returnCurrency != null) {
			MultiValueMap<String, String> headers = null;
			response = new ResponseEntity<Currency>(returnCurrency, headers, HttpStatus.FOUND);
		} else {
			response = new ResponseEntity<Currency>(null, null, HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(path = "/showAll", method = RequestMethod.GET)
	public ResponseEntity<List<Currency>> showAll() {

		List<Currency> listOfCurrencies = currencyService.showAll();
		ResponseEntity<List<Currency>> response = null;
		if (listOfCurrencies != null) {
			MultiValueMap<String, String> headers = null;
			response = new ResponseEntity<List<Currency>>(listOfCurrencies, headers, HttpStatus.FOUND);
		} else {
			response = new ResponseEntity<List<Currency>>(null, null, HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
