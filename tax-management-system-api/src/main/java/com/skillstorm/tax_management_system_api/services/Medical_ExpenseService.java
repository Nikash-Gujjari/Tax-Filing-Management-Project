package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Medical_ExpenseDTO;
import com.skillstorm.tax_management_system_api.models.Medical_Expense;
import com.skillstorm.tax_management_system_api.repositories.Medical_ExpenseRepository;

@Service
public class Medical_ExpenseService {

	private Medical_ExpenseRepository repo;
	
	public Medical_ExpenseService(Medical_ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Medical_Expense>> findAll() {
		
		Iterable<Medical_Expense> medical_expenses = repo.findAll();
		
		if (!medical_expenses.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(medical_expenses);
		else
			return ResponseEntity.status(HttpStatus.OK).body(medical_expenses);
		
	}
	
	public ResponseEntity<Medical_Expense> findById(int id) {
		Optional<Medical_Expense> medical_expenses = repo.findById(id);
		
		if (medical_expenses.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(medical_expenses.get());
	}
	
	public ResponseEntity<Medical_Expense> createOne(Medical_ExpenseDTO medical_expenseDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Medical_Expense(0, medical_expenseDTO.form_name(), medical_expenseDTO.form(), medical_expenseDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Medical_Expense> updateOne(int id, Medical_ExpenseDTO medical_expenseDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Medical_Expense(id, medical_expenseDTO.form_name(), medical_expenseDTO.form(), medical_expenseDTO.tax_return())));
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
