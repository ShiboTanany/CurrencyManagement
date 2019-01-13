package com.test.CurrencyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.CurrencyManagement.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Character> {

}
