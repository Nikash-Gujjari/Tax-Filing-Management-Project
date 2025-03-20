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

import com.skillstorm.tax_management_system_api.dtos.Medical_ExpenseDTO;
import com.skillstorm.tax_management_system_api.models.Medical_Expense;
import com.skillstorm.tax_management_system_api.services.Medical_ExpenseService;

@RestController
@RequestMapping("/medicalexpense")
public class Medical_ExpenseController {
	
	private Medical_ExpenseService service;
	
	public Medical_ExpenseController(Medical_ExpenseService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Medical_Expense>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Medical_Expense> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Medical_Expense> createOne(@RequestBody Medical_ExpenseDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Medical_Expense> updateOne(@PathVariable int id, @RequestBody Medical_ExpenseDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}