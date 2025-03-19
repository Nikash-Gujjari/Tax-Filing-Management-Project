package com.skillstorm.tax_management_system_api.dtos;

import java.util.List;

import com.skillstorm.tax_management_system_api.models.Charitable_Donation;
import com.skillstorm.tax_management_system_api.models.Cpa;
import com.skillstorm.tax_management_system_api.models.Dependent_Care_Expense;
import com.skillstorm.tax_management_system_api.models.Education_Expense;
import com.skillstorm.tax_management_system_api.models.Form_1099;
import com.skillstorm.tax_management_system_api.models.Health_Savings_Account_Contribution;
import com.skillstorm.tax_management_system_api.models.Investment_Income;
import com.skillstorm.tax_management_system_api.models.Local_Tax;
import com.skillstorm.tax_management_system_api.models.Medical_Expense;
import com.skillstorm.tax_management_system_api.models.Mortgage_Interest;
import com.skillstorm.tax_management_system_api.models.Other_Income;
import com.skillstorm.tax_management_system_api.models.Retirement_Contribution;
import com.skillstorm.tax_management_system_api.models.Retirement_Income;
import com.skillstorm.tax_management_system_api.models.State_Tax;
import com.skillstorm.tax_management_system_api.models.Student_Loan_Interest;
import com.skillstorm.tax_management_system_api.models.Taxpayer;
import com.skillstorm.tax_management_system_api.models.Unemployment_Benefit;
import com.skillstorm.tax_management_system_api.models.W2;

public record Tax_ReturnDTO(String filing_status, Cpa cpa, List<Taxpayer> taxpayer, W2 w2,
		Unemployment_Benefit unemployment_benefit, Student_Loan_Interest student_loan_interest, State_Tax state_tax,
		Local_Tax local_tax, Retirement_Income retirement_income, Retirement_Contribution retirement_contribution,
		Other_Income other_income, Mortgage_Interest mortgage_interest, Medical_Expense medical_expense,
		Investment_Income investment_income,
		Health_Savings_Account_Contribution health_savings_account_contribution, Form_1099 form_1099,
		Education_Expense education_expense, Dependent_Care_Expense dependent_care_expense,
		Charitable_Donation charitable_donation) {

}
