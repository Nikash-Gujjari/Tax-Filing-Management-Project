package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.CpaDTO;
import com.skillstorm.tax_management_system_api.models.Cpa;
import com.skillstorm.tax_management_system_api.repositories.CpaRepository;

@Service
public class CpaService {

	private CpaRepository repo;
	
	public CpaService(CpaRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Cpa>> findAll() {
		
		Iterable<Cpa> cpas = repo.findAll();
		
		if (!cpas.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cpas);
		else
			return ResponseEntity.status(HttpStatus.OK).body(cpas);
		
	}
	
	public ResponseEntity<Cpa> findById(int id) {
		Optional<Cpa> cpa = repo.findById(id);
		
		if (cpa.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(cpa.get());
	}
	
	public ResponseEntity<Cpa> createOne(CpaDTO cpaDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Cpa(0, cpaDTO.first_name(), cpaDTO.last_name(), cpaDTO.email(), cpaDTO.username(), cpaDTO.hashed_password(),
											cpaDTO.role(), cpaDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Cpa> updateOne(int id, CpaDTO cpaDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Cpa(id, cpaDTO.first_name(), cpaDTO.last_name(), cpaDTO.email(), cpaDTO.username(), cpaDTO.hashed_password(),
											cpaDTO.role(), cpaDTO.tax_return())));
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
