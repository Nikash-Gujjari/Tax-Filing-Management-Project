package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Medical_Expense;

@Repository
public interface Medical_ExpenseRepository extends CrudRepository<Medical_Expense, Integer> {

}
