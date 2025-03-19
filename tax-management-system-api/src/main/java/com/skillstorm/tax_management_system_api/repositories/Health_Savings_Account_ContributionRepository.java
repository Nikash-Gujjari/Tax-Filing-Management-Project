package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Health_Savings_Account_Contribution;

@Repository
public interface Health_Savings_Account_ContributionRepository extends CrudRepository<Health_Savings_Account_Contribution, Integer> {

}
