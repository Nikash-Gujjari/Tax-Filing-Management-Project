package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.State_TaxDTO;
import com.skillstorm.tax_management_system_api.models.State_Tax;
import com.skillstorm.tax_management_system_api.repositories.State_TaxRepository;

@Service
public class State_TaxService {

	private State_TaxRepository repo;
	
	public State_TaxService(State_TaxRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<State_Tax>> findAll() {
		
		Iterable<State_Tax> state_taxes = repo.findAll();
		
		if (!state_taxes.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(state_taxes);
		else
			return ResponseEntity.status(HttpStatus.OK).body(state_taxes);
		
	}
	
	public ResponseEntity<State_Tax> findById(int id) {
		Optional<State_Tax> state_taxes = repo.findById(id);
		
		if (state_taxes.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(state_taxes.get());
	}
	
	public ResponseEntity<State_Tax> createOne(State_TaxDTO state_taxDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new State_Tax(0, state_taxDTO.form_name(), state_taxDTO.form(), state_taxDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<State_Tax> updateOne(int id, State_TaxDTO state_taxDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new State_Tax(id, state_taxDTO.form_name(), state_taxDTO.form(), state_taxDTO.tax_return())));
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
