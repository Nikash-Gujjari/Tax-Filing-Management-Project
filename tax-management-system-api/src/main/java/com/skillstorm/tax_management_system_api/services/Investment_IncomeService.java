package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Investment_IncomeDTO;
import com.skillstorm.tax_management_system_api.models.Investment_Income;
import com.skillstorm.tax_management_system_api.repositories.Investment_IncomeRepository;

@Service
public class Investment_IncomeService {

	private Investment_IncomeRepository repo;
	
	public Investment_IncomeService(Investment_IncomeRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Investment_Income>> findAll() {
		
		Iterable<Investment_Income> education_expenses = repo.findAll();
		
		if (!education_expenses.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(education_expenses);
		else
			return ResponseEntity.status(HttpStatus.OK).body(education_expenses);
		
	}
	
	public ResponseEntity<Investment_Income> findById(int id) {
		Optional<Investment_Income> education_expenses = repo.findById(id);
		
		if (education_expenses.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(education_expenses.get());
	}
	
	public ResponseEntity<Investment_Income> createOne(Investment_IncomeDTO investment_incomeDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Investment_Income(0, investment_incomeDTO.form_name(), investment_incomeDTO.form(), investment_incomeDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Investment_Income> updateOne(int id, Investment_IncomeDTO investment_incomeDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Investment_Income(id, investment_incomeDTO.form_name(), investment_incomeDTO.form(), investment_incomeDTO.tax_return())));
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
