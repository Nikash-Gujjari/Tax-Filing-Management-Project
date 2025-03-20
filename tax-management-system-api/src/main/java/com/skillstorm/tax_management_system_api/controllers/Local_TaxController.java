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

import com.skillstorm.tax_management_system_api.dtos.Local_TaxDTO;
import com.skillstorm.tax_management_system_api.models.Local_Tax;
import com.skillstorm.tax_management_system_api.services.Local_TaxService;

@RestController
@RequestMapping("/localtax")
public class Local_TaxController {
	
	private Local_TaxService service;
	
	public Local_TaxController(Local_TaxService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Local_Tax>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Local_Tax> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Local_Tax> createOne(@RequestBody Local_TaxDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Local_Tax> updateOne(@PathVariable int id, @RequestBody Local_TaxDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}