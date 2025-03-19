package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Investment_Income;

@Repository
public interface Investment_IncomeRepository extends CrudRepository<Investment_Income, Integer> {

}
