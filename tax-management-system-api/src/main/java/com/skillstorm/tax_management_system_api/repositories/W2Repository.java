package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.W2;

@Repository
public interface W2Repository extends CrudRepository<W2, Integer> {

}
