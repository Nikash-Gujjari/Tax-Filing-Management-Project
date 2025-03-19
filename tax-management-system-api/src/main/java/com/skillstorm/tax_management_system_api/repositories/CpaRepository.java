package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Cpa;

@Repository
public interface CpaRepository extends CrudRepository<Cpa, Integer> {

}
