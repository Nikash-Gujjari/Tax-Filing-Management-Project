package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.W2DTO;
import com.skillstorm.tax_management_system_api.models.W2;
import com.skillstorm.tax_management_system_api.repositories.W2Repository;

@Service
public class W2Service {

	private W2Repository repo;
	
	public W2Service(W2Repository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<W2>> findAll() {
		
		Iterable<W2> w2s = repo.findAll();
		
		if (!w2s.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(w2s);
		else
			return ResponseEntity.status(HttpStatus.OK).body(w2s);
		
	}
	
	public ResponseEntity<W2> findById(int id) {
		Optional<W2> w2s = repo.findById(id);
		
		if (w2s.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(w2s.get());
	}
	
	public ResponseEntity<W2> createOne(W2DTO w2DTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new W2(0, w2DTO.form_name(), w2DTO.form(), w2DTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<W2> updateOne(int id, W2DTO w2DTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new W2(id, w2DTO.form_name(), w2DTO.form(), w2DTO.tax_return())));
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
