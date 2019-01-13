package com.test.CurrencyManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.CurrencyManagement.entities.User;
import com.test.CurrencyManagement.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public User loginUser(String userName, String hashedPassword) {
		return repository.findByUserNameAndHashedPassword(userName, hashedPassword);
	}

	public User findOne(String userName) {

		return repository.findByUserName(userName);
	}

}
