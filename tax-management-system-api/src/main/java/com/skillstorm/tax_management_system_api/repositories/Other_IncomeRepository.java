package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Other_Income;

@Repository
public interface Other_IncomeRepository extends CrudRepository<Other_Income, Integer> {

}
