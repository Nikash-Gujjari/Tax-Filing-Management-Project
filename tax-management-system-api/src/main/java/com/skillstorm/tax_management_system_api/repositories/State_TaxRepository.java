package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.State_Tax;

@Repository
public interface State_TaxRepository extends CrudRepository<State_Tax, Integer> {

}
