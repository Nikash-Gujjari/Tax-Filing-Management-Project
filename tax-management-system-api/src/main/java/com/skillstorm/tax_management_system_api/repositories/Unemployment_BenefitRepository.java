package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Unemployment_Benefit;

@Repository
public interface Unemployment_BenefitRepository extends CrudRepository<Unemployment_Benefit, Integer> {

}
