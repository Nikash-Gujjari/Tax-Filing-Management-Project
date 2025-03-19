package com.skillstorm.tax_management_system_api.dtos;

import java.sql.Blob;

import com.skillstorm.tax_management_system_api.models.Tax_Return;

public record Other_IncomeDTO(String form_name, Blob form, Tax_Return tax_return) {

}
