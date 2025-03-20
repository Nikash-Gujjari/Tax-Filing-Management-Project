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

public record Tax_ReturnDTO(String filing_status, Cpa cpa, List<Taxpayer> taxpayer, List<W2> w2,
		List<Unemployment_Benefit> unemployment_benefit, List<Student_Loan_Interest> student_loan_interest, List<State_Tax> state_tax,
		List<Local_Tax> local_tax, List<Retirement_Income> retirement_income, List<Retirement_Contribution> retirement_contribution,
		List<Other_Income> other_income, List<Mortgage_Interest> mortgage_interest, List<Medical_Expense> medical_expense,
		List<Investment_Income> investment_income, List<Health_Savings_Account_Contribution> health_savings_account_contribution, List<Form_1099> form_1099,
		List<Education_Expense> education_expense, List<Dependent_Care_Expense> dependent_care_expense,
		List<Charitable_Donation> charitable_donation) {

}
