package com.safeTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.safeTravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
	List<Expense> findByDescriptionContaining(String search);

}