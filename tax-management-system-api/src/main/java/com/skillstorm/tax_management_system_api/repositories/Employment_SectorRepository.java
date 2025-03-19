package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Employment_Sector;

@Repository
public interface Employment_SectorRepository extends CrudRepository<Employment_Sector, Integer> {

}
