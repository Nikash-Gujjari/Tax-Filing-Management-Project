package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Education_Expense;

@Repository
public interface Education_ExpenseRepository extends CrudRepository<Education_Expense, Integer> {

}
