package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Other_IncomeDTO;
import com.skillstorm.tax_management_system_api.models.Other_Income;
import com.skillstorm.tax_management_system_api.repositories.Other_IncomeRepository;

@Service
public class Other_IncomeService {

	private Other_IncomeRepository repo;
	
	public Other_IncomeService(Other_IncomeRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Other_Income>> findAll() {
		
		Iterable<Other_Income> other_incomes = repo.findAll();
		
		if (!other_incomes.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(other_incomes);
		else
			return ResponseEntity.status(HttpStatus.OK).body(other_incomes);
		
	}
	
	public ResponseEntity<Other_Income> findById(int id) {
		Optional<Other_Income> other_incomes = repo.findById(id);
		
		if (other_incomes.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(other_incomes.get());
	}
	
	public ResponseEntity<Other_Income> createOne(Other_IncomeDTO other_incomeDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Other_Income(0, other_incomeDTO.form_name(), other_incomeDTO.form(), other_incomeDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Other_Income> updateOne(int id, Other_IncomeDTO other_incomeDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Other_Income(id, other_incomeDTO.form_name(), other_incomeDTO.form(), other_incomeDTO.tax_return())));
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
