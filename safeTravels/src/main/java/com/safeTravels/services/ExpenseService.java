package com.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.safeTravels.models.Expense;
import com.safeTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	public Expense updateExpense(Long id, String name, String vendor, Double amount, String description) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			Expense expense = optionalExpense.get();
			expense.setName(name);
			expense.setVendor(vendor);
			expense.setAmount(amount);
			expense.setDescription(description);
			return expenseRepository.save(expense);
		}
		else {
			return null;
		}
	}
	public Expense updateExpense(Expense expense) {
		Optional<Expense> optionalExpense = expenseRepository.findById(expense.getId());
	    if (optionalExpense.isPresent()) {
	        return expenseRepository.save(expense);
	    } else {
	        return null;
	    }
	}
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
