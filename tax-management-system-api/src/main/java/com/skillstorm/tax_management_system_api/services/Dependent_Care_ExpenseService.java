package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Dependent_Care_ExpenseDTO;
import com.skillstorm.tax_management_system_api.models.Dependent_Care_Expense;
import com.skillstorm.tax_management_system_api.repositories.Dependent_Care_ExpenseRepository;

@Service
public class Dependent_Care_ExpenseService {

	private Dependent_Care_ExpenseRepository repo;
	
	public Dependent_Care_ExpenseService(Dependent_Care_ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Dependent_Care_Expense>> findAll() {
		
		Iterable<Dependent_Care_Expense> dependent_care_expenses = repo.findAll();
		
		if (!dependent_care_expenses.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dependent_care_expenses);
		else
			return ResponseEntity.status(HttpStatus.OK).body(dependent_care_expenses);
		
	}
	
	public ResponseEntity<Dependent_Care_Expense> findById(int id) {
		Optional<Dependent_Care_Expense> dependent_care_expense = repo.findById(id);
		
		if (dependent_care_expense.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(dependent_care_expense.get());
	}
	
	public ResponseEntity<Dependent_Care_Expense> createOne(Dependent_Care_ExpenseDTO dependent_care_expenseDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Dependent_Care_Expense(0, dependent_care_expenseDTO.form_name(), dependent_care_expenseDTO.form(), dependent_care_expenseDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Dependent_Care_Expense> updateOne(int id, Dependent_Care_ExpenseDTO dependent_care_expenseDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Dependent_Care_Expense(id, dependent_care_expenseDTO.form_name(), dependent_care_expenseDTO.form(), dependent_care_expenseDTO.tax_return())));
		else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	public ResponseEntity<Void> deleteById(int id) {
		try {
			repo.deleteById(id); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	
}
