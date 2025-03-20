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

import com.skillstorm.tax_management_system_api.dtos.Dependent_Care_ExpenseDTO;
import com.skillstorm.tax_management_system_api.models.Dependent_Care_Expense;
import com.skillstorm.tax_management_system_api.services.Dependent_Care_ExpenseService;

@RestController
@RequestMapping("/dependentcareexpense")
public class Dependent_Care_ExpenseController {
	
	private Dependent_Care_ExpenseService service;
	
	public Dependent_Care_ExpenseController(Dependent_Care_ExpenseService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Dependent_Care_Expense>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Dependent_Care_Expense> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Dependent_Care_Expense> createOne(@RequestBody Dependent_Care_ExpenseDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Dependent_Care_Expense> updateOne(@PathVariable int id, @RequestBody Dependent_Care_ExpenseDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}