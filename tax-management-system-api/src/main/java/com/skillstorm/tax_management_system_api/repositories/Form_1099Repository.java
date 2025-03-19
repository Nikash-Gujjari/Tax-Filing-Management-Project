package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Form_1099;

@Repository
public interface Form_1099Repository extends CrudRepository<Form_1099, Integer> {

}
