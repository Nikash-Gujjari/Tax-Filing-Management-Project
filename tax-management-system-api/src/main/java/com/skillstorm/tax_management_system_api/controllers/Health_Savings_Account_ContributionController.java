package com.skillstorm.tax_management_system_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.tax_management_system_api.dtos.Health_Savings_Account_ContributionDTO;
import com.skillstorm.tax_management_system_api.models.Health_Savings_Account_Contribution;
import com.skillstorm.tax_management_system_api.services.Health_Savings_Account_ContributionService;

@RestController
@RequestMapping("/healthsavingsaccountcontribution")
public class Health_Savings_Account_ContributionController {
	
	private Health_Savings_Account_ContributionService service;
	
	public Health_Savings_Account_ContributionController(Health_Savings_Account_ContributionService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Health_Savings_Account_Contribution>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Health_Savings_Account_Contribution> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Health_Savings_Account_Contribution> createOne(@RequestBody Health_Savings_Account_ContributionDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Health_Savings_Account_Contribution> updateOne(@PathVariable int id, @RequestBody Health_Savings_Account_ContributionDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}