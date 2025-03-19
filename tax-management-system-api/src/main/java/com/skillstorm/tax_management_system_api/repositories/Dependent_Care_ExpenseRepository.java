package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Dependent_Care_Expense;

@Repository
public interface Dependent_Care_ExpenseRepository extends CrudRepository<Dependent_Care_Expense, Integer> {

}
