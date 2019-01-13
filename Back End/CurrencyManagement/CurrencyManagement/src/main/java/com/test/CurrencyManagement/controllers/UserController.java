package com.test.CurrencyManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.CurrencyManagement.entities.User;
import com.test.CurrencyManagement.services.JwtTokenService;
import com.test.CurrencyManagement.services.UserService;

@RestController
@RequestMapping(value = "/tokens")
@DependsOn("jwtTokenService")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenService jwtTokenUtil;

	@Autowired
	private BCryptPasswordEncoder bcryptPassword;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/getToken", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User inputUser) {
		String userName = null;
		String hashedPassword = null;
		if (inputUser != null) {
			userName = inputUser.getUserName();
			hashedPassword = inputUser.getHashedPassword();
		}

		ResponseEntity<User> response = null;
		if (userName != null & hashedPassword != null & !userName.isEmpty() && !hashedPassword.isEmpty()) {
			User user = userService.findOne(userName);

			if (user != null && bcryptPassword.matches(hashedPassword, user.getHashedPassword())) {
				MultiValueMap<String, String> headers = new HttpHeaders();
				final String token = jwtTokenUtil.generateToken(user);
				headers.add("Authorization", token);
				response = new ResponseEntity<User>(user, headers, HttpStatus.FOUND);
			} else {
				response = null;
				new ResponseEntity<User>(null, null, HttpStatus.NOT_FOUND);
			}
		}

		if (response == null)
			response = new ResponseEntity<User>(null, null, HttpStatus.NOT_FOUND);

		return response;
	}

}
