package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Charitable_Donation;

@Repository
public interface Charitable_DonationRepository extends CrudRepository<Charitable_Donation, Integer> {

}
