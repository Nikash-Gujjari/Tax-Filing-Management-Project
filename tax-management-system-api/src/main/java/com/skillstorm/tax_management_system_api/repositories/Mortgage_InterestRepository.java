package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Mortgage_Interest;

@Repository
public interface Mortgage_InterestRepository extends CrudRepository<Mortgage_Interest, Integer> {

}
