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

import com.skillstorm.tax_management_system_api.dtos.Student_Loan_InterestDTO;
import com.skillstorm.tax_management_system_api.models.Student_Loan_Interest;
import com.skillstorm.tax_management_system_api.services.Student_Loan_InterestService;

@RestController
@RequestMapping("/studentloaninterest")
public class Student_Loan_InterestController {
	
	private Student_Loan_InterestService service;
	
	public Student_Loan_InterestController(Student_Loan_InterestService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Student_Loan_Interest>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Student_Loan_Interest> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Student_Loan_Interest> createOne(@RequestBody Student_Loan_InterestDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Student_Loan_Interest> updateOne(@PathVariable int id, @RequestBody Student_Loan_InterestDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}