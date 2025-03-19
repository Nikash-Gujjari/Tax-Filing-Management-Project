package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Health_Savings_Account_ContributionDTO;
import com.skillstorm.tax_management_system_api.models.Health_Savings_Account_Contribution;
import com.skillstorm.tax_management_system_api.repositories.Health_Savings_Account_ContributionRepository;

@Service
public class Health_Savings_Account_ContributionService {

	private Health_Savings_Account_ContributionRepository repo;
	
	public Health_Savings_Account_ContributionService(Health_Savings_Account_ContributionRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Health_Savings_Account_Contribution>> findAll() {
		
		Iterable<Health_Savings_Account_Contribution> health_savings_account_contributions = repo.findAll();
		
		if (!health_savings_account_contributions.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(health_savings_account_contributions);
		else
			return ResponseEntity.status(HttpStatus.OK).body(health_savings_account_contributions);
		
	}
	
	public ResponseEntity<Health_Savings_Account_Contribution> findById(int id) {
		Optional<Health_Savings_Account_Contribution> health_savings_account_contributions = repo.findById(id);
		
		if (health_savings_account_contributions.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(health_savings_account_contributions.get());
	}
	
	public ResponseEntity<Health_Savings_Account_Contribution> createOne(Health_Savings_Account_ContributionDTO health_savings_account_contributionsDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Health_Savings_Account_Contribution(0, health_savings_account_contributionsDTO.form_name(), health_savings_account_contributionsDTO.form(), health_savings_account_contributionsDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Health_Savings_Account_Contribution> updateOne(int id, Health_Savings_Account_ContributionDTO health_savings_account_contributionsDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Health_Savings_Account_Contribution(id, health_savings_account_contributionsDTO.form_name(), health_savings_account_contributionsDTO.form(), health_savings_account_contributionsDTO.tax_return())));
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
