package com.test.CurrencyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.CurrencyManagement.entities.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	public User findByUserNameAndHashedPassword(String userName , String hashedPassword);
	public User findByUserName(String userName);

}
