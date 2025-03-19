package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Local_Tax;

@Repository
public interface Local_TaxRepository extends CrudRepository<Local_Tax, Integer> {

}
