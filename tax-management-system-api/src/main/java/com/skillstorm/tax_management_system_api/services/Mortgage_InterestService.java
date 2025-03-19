package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Mortgage_InterestDTO;
import com.skillstorm.tax_management_system_api.models.Mortgage_Interest;
import com.skillstorm.tax_management_system_api.repositories.Mortgage_InterestRepository;

@Service
public class Mortgage_InterestService {

	private Mortgage_InterestRepository repo;
	
	public Mortgage_InterestService(Mortgage_InterestRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Mortgage_Interest>> findAll() {
		
		Iterable<Mortgage_Interest> mortgage_interests = repo.findAll();
		
		if (!mortgage_interests.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mortgage_interests);
		else
			return ResponseEntity.status(HttpStatus.OK).body(mortgage_interests);
		
	}
	
	public ResponseEntity<Mortgage_Interest> findById(int id) {
		Optional<Mortgage_Interest> mortgage_interests = repo.findById(id);
		
		if (mortgage_interests.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(mortgage_interests.get());
	}
	
	public ResponseEntity<Mortgage_Interest> createOne(Mortgage_InterestDTO mortgage_interestDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Mortgage_Interest(0, mortgage_interestDTO.form_name(), mortgage_interestDTO.form(), mortgage_interestDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Mortgage_Interest> updateOne(int id, Mortgage_InterestDTO mortgage_interestDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Mortgage_Interest(id, mortgage_interestDTO.form_name(), mortgage_interestDTO.form(), mortgage_interestDTO.tax_return())));
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
