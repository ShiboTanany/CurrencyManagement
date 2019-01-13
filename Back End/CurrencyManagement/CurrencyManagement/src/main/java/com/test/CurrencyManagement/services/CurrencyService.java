package com.test.CurrencyManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.CurrencyManagement.entities.Currency;
import com.test.CurrencyManagement.repositories.CurrencyRepository;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepository repository;

	public CurrencyRepository getRepository() {
		return repository;
	}

	public void setRepository(CurrencyRepository repository) {
		this.repository = repository;
	}

	public Currency createCurrency(Currency currency) {
		return repository.save(currency);
	}

	public List<Currency> showAll() {
		return repository.findAll();
	}
}
