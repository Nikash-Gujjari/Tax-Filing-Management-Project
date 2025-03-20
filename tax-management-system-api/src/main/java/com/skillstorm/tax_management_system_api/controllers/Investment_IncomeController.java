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

import com.skillstorm.tax_management_system_api.dtos.Investment_IncomeDTO;
import com.skillstorm.tax_management_system_api.models.Investment_Income;
import com.skillstorm.tax_management_system_api.services.Investment_IncomeService;

@RestController
@RequestMapping("/investmentincome")
public class Investment_IncomeController {
	
	private Investment_IncomeService service;
	
	public Investment_IncomeController(Investment_IncomeService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Investment_Income>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Investment_Income> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Investment_Income> createOne(@RequestBody Investment_IncomeDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Investment_Income> updateOne(@PathVariable int id, @RequestBody Investment_IncomeDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}