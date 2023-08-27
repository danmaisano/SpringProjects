package com.safeTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safeTravels.models.Expense;
import com.safeTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	//Read
	@RequestMapping("/expenses")
	public String index(Model model) {
	    List<Expense> expenses = expenseService.allExpenses();
	    model.addAttribute("expenses", expenses);
	    model.addAttribute("expense", new Expense()); 
	    return "expenses.jsp";
	}
	@GetMapping("/expenses/{id}")
    public String showExpense(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        if (expense != null) {
            model.addAttribute("expense", expense);
            return "view.jsp";
        } else {
            return "notFound.jsp";
        }
    }

	//Create

	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		System.out.println("first");
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            List<Expense> expenses = expenseService.allExpenses();
            model.addAttribute("expenses", expenses);
            return "expenses.jsp";
        } else {
            expenseService.createExpense(expense);
            System.out.println("added");
            return "redirect:/expenses";
        }
    }
	
	//Update
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
            model.addAttribute("expense", expense);
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
	}
	//Delete
	@DeleteMapping("/expenses/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	
	
}