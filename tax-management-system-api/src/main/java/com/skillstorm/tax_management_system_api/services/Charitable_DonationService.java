package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Charitable_DonationDTO;
import com.skillstorm.tax_management_system_api.models.Charitable_Donation;
import com.skillstorm.tax_management_system_api.repositories.Charitable_DonationRepository;

@Service
public class Charitable_DonationService {

	private Charitable_DonationRepository repo;
	
	public Charitable_DonationService(Charitable_DonationRepository repo) {
		this.repo = repo;
	}
	

	public ResponseEntity<Iterable<Charitable_Donation>> findAll() {
		
		Iterable<Charitable_Donation> charitable_donations = repo.findAll();
		
		if (!charitable_donations.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(charitable_donations);
		else
			return ResponseEntity.status(HttpStatus.OK).body(charitable_donations);
		
	}
	

	public ResponseEntity<Charitable_Donation> findById(int id) {
		Optional<Charitable_Donation> charitable_donation = repo.findById(id);
		
		if (charitable_donation.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(charitable_donation.get());
	}
	

	public ResponseEntity<Charitable_Donation> createOne(Charitable_DonationDTO charitable_donationDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Charitable_Donation(0, charitable_donationDTO.form_name(), charitable_donationDTO.form(), charitable_donationDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Charitable_Donation> updateOne(int id, Charitable_DonationDTO charitable_donationDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Charitable_Donation(id, charitable_donationDTO.form_name(), charitable_donationDTO.form(), charitable_donationDTO.tax_return())));
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
