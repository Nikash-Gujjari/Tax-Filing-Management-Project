package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Local_TaxDTO;
import com.skillstorm.tax_management_system_api.models.Local_Tax;
import com.skillstorm.tax_management_system_api.repositories.Local_TaxRepository;

@Service
public class Local_TaxService {

	private Local_TaxRepository repo;
	
	public Local_TaxService(Local_TaxRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Local_Tax>> findAll() {
		
		Iterable<Local_Tax> local_taxes = repo.findAll();
		
		if (!local_taxes.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(local_taxes);
		else
			return ResponseEntity.status(HttpStatus.OK).body(local_taxes);
		
	}
	
	public ResponseEntity<Local_Tax> findById(int id) {
		Optional<Local_Tax> local_taxes = repo.findById(id);
		
		if (local_taxes.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(local_taxes.get());
	}
	
	public ResponseEntity<Local_Tax> createOne(Local_TaxDTO local_TaxDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Local_Tax(0, local_TaxDTO.form_name(), local_TaxDTO.form(), local_TaxDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Local_Tax> updateOne(int id, Local_TaxDTO local_TaxDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Local_Tax(id, local_TaxDTO.form_name(), local_TaxDTO.form(), local_TaxDTO.tax_return())));
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
