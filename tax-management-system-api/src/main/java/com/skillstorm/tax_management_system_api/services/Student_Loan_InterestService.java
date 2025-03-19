package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Student_Loan_InterestDTO;
import com.skillstorm.tax_management_system_api.models.Student_Loan_Interest;
import com.skillstorm.tax_management_system_api.repositories.Student_Loan_InterestRepository;

@Service
public class Student_Loan_InterestService {

	private Student_Loan_InterestRepository repo;
	
	public Student_Loan_InterestService(Student_Loan_InterestRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Student_Loan_Interest>> findAll() {
		
		Iterable<Student_Loan_Interest> student_loan_interests = repo.findAll();
		
		if (!student_loan_interests.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(student_loan_interests);
		else
			return ResponseEntity.status(HttpStatus.OK).body(student_loan_interests);
		
	}
	
	public ResponseEntity<Student_Loan_Interest> findById(int id) {
		Optional<Student_Loan_Interest> student_loan_interests = repo.findById(id);
		
		if (student_loan_interests.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(student_loan_interests.get());
	}
	
	public ResponseEntity<Student_Loan_Interest> createOne(Student_Loan_InterestDTO student_loan_interestDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Student_Loan_Interest(0, student_loan_interestDTO.form_name(), student_loan_interestDTO.form(), student_loan_interestDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Student_Loan_Interest> updateOne(int id, Student_Loan_InterestDTO student_loan_interestDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Student_Loan_Interest(id, student_loan_interestDTO.form_name(), student_loan_interestDTO.form(), student_loan_interestDTO.tax_return())));
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
