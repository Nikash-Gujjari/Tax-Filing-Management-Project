package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Education_ExpenseDTO;
import com.skillstorm.tax_management_system_api.models.Education_Expense;
import com.skillstorm.tax_management_system_api.repositories.Education_ExpenseRepository;

@Service
public class Education_ExpenseService {

	private Education_ExpenseRepository repo;
	
	public Education_ExpenseService(Education_ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Education_Expense>> findAll() {
		
		Iterable<Education_Expense> education_expenses = repo.findAll();
		
		if (!education_expenses.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(education_expenses);
		else
			return ResponseEntity.status(HttpStatus.OK).body(education_expenses);
		
	}
	
	public ResponseEntity<Education_Expense> findById(int id) {
		Optional<Education_Expense> education_expenses = repo.findById(id);
		
		if (education_expenses.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(education_expenses.get());
	}
	
	public ResponseEntity<Education_Expense> createOne(Education_ExpenseDTO education_expenseDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Education_Expense(0, education_expenseDTO.form_name(), education_expenseDTO.form(), education_expenseDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Education_Expense> updateOne(int id, Education_ExpenseDTO education_expenseDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Education_Expense(id, education_expenseDTO.form_name(), education_expenseDTO.form(), education_expenseDTO.tax_return())));
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
