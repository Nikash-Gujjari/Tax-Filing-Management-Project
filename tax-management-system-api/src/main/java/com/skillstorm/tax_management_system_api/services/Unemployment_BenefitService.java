package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Unemployment_BenefitDTO;
import com.skillstorm.tax_management_system_api.models.Unemployment_Benefit;
import com.skillstorm.tax_management_system_api.repositories.Unemployment_BenefitRepository;

@Service
public class Unemployment_BenefitService {

	private Unemployment_BenefitRepository repo;
	
	public Unemployment_BenefitService(Unemployment_BenefitRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Unemployment_Benefit>> findAll() {
		
		Iterable<Unemployment_Benefit> unemployment_benefits = repo.findAll();
		
		if (!unemployment_benefits.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(unemployment_benefits);
		else
			return ResponseEntity.status(HttpStatus.OK).body(unemployment_benefits);
		
	}
	
	public ResponseEntity<Unemployment_Benefit> findById(int id) {
		Optional<Unemployment_Benefit> unemployment_benefits = repo.findById(id);
		
		if (unemployment_benefits.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(unemployment_benefits.get());
	}
	
	public ResponseEntity<Unemployment_Benefit> createOne(Unemployment_BenefitDTO unemployment_benefitDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Unemployment_Benefit(0, unemployment_benefitDTO.form_name(), unemployment_benefitDTO.form(), unemployment_benefitDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Unemployment_Benefit> updateOne(int id, Unemployment_BenefitDTO unemployment_benefitDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Unemployment_Benefit(id, unemployment_benefitDTO.form_name(), unemployment_benefitDTO.form(), unemployment_benefitDTO.tax_return())));
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
