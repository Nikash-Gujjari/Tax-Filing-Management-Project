
package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Retirement_Income;

@Repository
public interface Retirement_IncomeRepository extends CrudRepository<Retirement_Income, Integer> {

}
