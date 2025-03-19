package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Form_1099DTO;
import com.skillstorm.tax_management_system_api.models.Form_1099;
import com.skillstorm.tax_management_system_api.repositories.Form_1099Repository;

@Service
public class Form_1099Service {

	private Form_1099Repository repo;
	
	public Form_1099Service(Form_1099Repository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Form_1099>> findAll() {
		
		Iterable<Form_1099> form_1099s = repo.findAll();
		
		if (!form_1099s.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(form_1099s);
		else
			return ResponseEntity.status(HttpStatus.OK).body(form_1099s);
		
	}
	
	public ResponseEntity<Form_1099> findById(int id) {
		Optional<Form_1099> form_1099s = repo.findById(id);
		
		if (form_1099s.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(form_1099s.get());
	}
	
	public ResponseEntity<Form_1099> createOne(Form_1099DTO form_1099DTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Form_1099(0, form_1099DTO.form_name(), form_1099DTO.form(), form_1099DTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Form_1099> updateOne(int id, Form_1099DTO form_1099DTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Form_1099(id, form_1099DTO.form_name(), form_1099DTO.form(), form_1099DTO.tax_return())));
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
