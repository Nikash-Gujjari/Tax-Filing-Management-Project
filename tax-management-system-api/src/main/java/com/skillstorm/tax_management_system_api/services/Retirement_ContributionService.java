package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Retirement_ContributionDTO;
import com.skillstorm.tax_management_system_api.models.Retirement_Contribution;
import com.skillstorm.tax_management_system_api.repositories.Retirement_ContributionRepository;

@Service
public class Retirement_ContributionService {

	private Retirement_ContributionRepository repo;
	
	public Retirement_ContributionService(Retirement_ContributionRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Retirement_Contribution>> findAll() {
		
		Iterable<Retirement_Contribution> retirement_contributions = repo.findAll();
		
		if (!retirement_contributions.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(retirement_contributions);
		else
			return ResponseEntity.status(HttpStatus.OK).body(retirement_contributions);
		
	}
	
	public ResponseEntity<Retirement_Contribution> findById(int id) {
		Optional<Retirement_Contribution> retirement_contributions = repo.findById(id);
		
		if (retirement_contributions.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(retirement_contributions.get());
	}
	
	public ResponseEntity<Retirement_Contribution> createOne(Retirement_ContributionDTO retirement_contributionDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Retirement_Contribution(0, retirement_contributionDTO.form_name(), retirement_contributionDTO.form(), retirement_contributionDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Retirement_Contribution> updateOne(int id, Retirement_ContributionDTO retirement_contributionDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Retirement_Contribution(id, retirement_contributionDTO.form_name(), retirement_contributionDTO.form(), retirement_contributionDTO.tax_return())));
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
