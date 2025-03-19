package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Student_Loan_Interest;

@Repository
public interface Student_Loan_InterestRepository extends CrudRepository<Student_Loan_Interest, Integer> {

}
