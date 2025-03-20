package com.skillstorm.tax_management_system_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Tax_Return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int tax_return_id;
	
	@Column
	private String filing_status;
	
	@ManyToOne
	@JoinColumn(name="cpa", referencedColumnName = "cpa_id")
	@JsonIgnoreProperties("tax_return")
	private Cpa cpa;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Taxpayer> taxpayer;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<W2> w2;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Unemployment_Benefit> unemployment_benefit;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Student_Loan_Interest> student_loan_interest;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<State_Tax> state_tax;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Local_Tax> local_tax;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Retirement_Income> retirement_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Retirement_Contribution> retirement_contribution;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Other_Income> other_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Mortgage_Interest> mortgage_interest;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Medical_Expense> medical_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Investment_Income> investment_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Health_Savings_Account_Contribution>health_savings_account_contribution;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Form_1099> form_1099;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Education_Expense> education_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Dependent_Care_Expense> dependent_care_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Charitable_Donation> charitable_donation;
	
	
	public Tax_Return() {
		super();
	}


	public Tax_Return(int tax_return_id, String filing_status, Cpa cpa, List<Taxpayer> taxpayer, List<W2> w2,
			List<Unemployment_Benefit> unemployment_benefit, List<Student_Loan_Interest> student_loan_interest,
			List<State_Tax> state_tax, List<Local_Tax> local_tax, List<Retirement_Income> retirement_income,
			List<Retirement_Contribution> retirement_contribution, List<Other_Income> other_income,
			List<Mortgage_Interest> mortgage_interest, List<Medical_Expense> medical_expense,
			List<Investment_Income> investment_income,
			List<Health_Savings_Account_Contribution> health_savings_account_contribution, List<Form_1099> form_1099,
			List<Education_Expense> education_expense, List<Dependent_Care_Expense> dependent_care_expense,
			List<Charitable_Donation> charitable_donation) {
		super();
		this.tax_return_id = tax_return_id;
		this.filing_status = filing_status;
		this.cpa = cpa;
		this.taxpayer = taxpayer;
		this.w2 = w2;
		this.unemployment_benefit = unemployment_benefit;
		this.student_loan_interest = student_loan_interest;
		this.state_tax = state_tax;
		this.local_tax = local_tax;
		this.retirement_income = retirement_income;
		this.retirement_contribution = retirement_contribution;
		this.other_income = other_income;
		this.mortgage_interest = mortgage_interest;
		this.medical_expense = medical_expense;
		this.investment_income = investment_income;
		this.health_savings_account_contribution = health_savings_account_contribution;
		this.form_1099 = form_1099;
		this.education_expense = education_expense;
		this.dependent_care_expense = dependent_care_expense;
		this.charitable_donation = charitable_donation;
	}


	public int getTax_return_id() {
		return tax_return_id;
	}


	public void setTax_return_id(int tax_return_id) {
		this.tax_return_id = tax_return_id;
	}


	public String getFiling_status() {
		return filing_status;
	}


	public void setFiling_status(String filing_status) {
		this.filing_status = filing_status;
	}


	public Cpa getCpa() {
		return cpa;
	}


	public void setCpa(Cpa cpa) {
		this.cpa = cpa;
	}


	public List<Taxpayer> getTaxpayer() {
		return taxpayer;
	}


	public void setTaxpayer(List<Taxpayer> taxpayer) {
		this.taxpayer = taxpayer;
	}


	public List<W2> getW2() {
		return w2;
	}


	public void setW2(List<W2> w2) {
		this.w2 = w2;
	}


	public List<Unemployment_Benefit> getUnemployment_benefit() {
		return unemployment_benefit;
	}


	public void setUnemployment_benefit(List<Unemployment_Benefit> unemployment_benefit) {
		this.unemployment_benefit = unemployment_benefit;
	}


	public List<Student_Loan_Interest> getStudent_loan_interest() {
		return student_loan_interest;
	}


	public void setStudent_loan_interest(List<Student_Loan_Interest> student_loan_interest) {
		this.student_loan_interest = student_loan_interest;
	}


	public List<State_Tax> getState_tax() {
		return state_tax;
	}


	public void setState_tax(List<State_Tax> state_tax) {
		this.state_tax = state_tax;
	}


	public List<Local_Tax> getLocal_tax() {
		return local_tax;
	}


	public void setLocal_tax(List<Local_Tax> local_tax) {
		this.local_tax = local_tax;
	}


	public List<Retirement_Income> getRetirement_income() {
		return retirement_income;
	}


	public void setRetirement_income(List<Retirement_Income> retirement_income) {
		this.retirement_income = retirement_income;
	}


	public List<Retirement_Contribution> getRetirement_contribution() {
		return retirement_contribution;
	}


	public void setRetirement_contribution(List<Retirement_Contribution> retirement_contribution) {
		this.retirement_contribution = retirement_contribution;
	}


	public List<Other_Income> getOther_income() {
		return other_income;
	}


	public void setOther_income(List<Other_Income> other_income) {
		this.other_income = other_income;
	}


	public List<Mortgage_Interest> getMortgage_interest() {
		return mortgage_interest;
	}


	public void setMortgage_interest(List<Mortgage_Interest> mortgage_interest) {
		this.mortgage_interest = mortgage_interest;
	}


	public List<Medical_Expense> getMedical_expense() {
		return medical_expense;
	}


	public void setMedical_expense(List<Medical_Expense> medical_expense) {
		this.medical_expense = medical_expense;
	}


	public List<Investment_Income> getInvestment_income() {
		return investment_income;
	}


	public void setInvestment_income(List<Investment_Income> investment_income) {
		this.investment_income = investment_income;
	}


	public List<Health_Savings_Account_Contribution> getHealth_savings_account_contribution() {
		return health_savings_account_contribution;
	}


	public void setHealth_savings_account_contribution(
			List<Health_Savings_Account_Contribution> health_savings_account_contribution) {
		this.health_savings_account_contribution = health_savings_account_contribution;
	}


	public List<Form_1099> getForm_1099() {
		return form_1099;
	}


	public void setForm_1099(List<Form_1099> form_1099) {
		this.form_1099 = form_1099;
	}


	public List<Education_Expense> getEducation_expense() {
		return education_expense;
	}


	public void setEducation_expense(List<Education_Expense> education_expense) {
		this.education_expense = education_expense;
	}


	public List<Dependent_Care_Expense> getDependent_care_expense() {
		return dependent_care_expense;
	}


	public void setDependent_care_expense(List<Dependent_Care_Expense> dependent_care_expense) {
		this.dependent_care_expense = dependent_care_expense;
	}


	public List<Charitable_Donation> getCharitable_donation() {
		return charitable_donation;
	}


	public void setCharitable_donation(List<Charitable_Donation> charitable_donation) {
		this.charitable_donation = charitable_donation;
	}


	@Override
	public String toString() {
		return "Tax_Return [tax_return_id=" + tax_return_id + ", filing_status=" + filing_status + ", cpa=" + cpa
				+ ", taxpayer=" + taxpayer + ", w2=" + w2 + ", unemployment_benefit=" + unemployment_benefit
				+ ", student_loan_interest=" + student_loan_interest + ", state_tax=" + state_tax + ", local_tax="
				+ local_tax + ", retirement_income=" + retirement_income + ", retirement_contribution="
				+ retirement_contribution + ", other_income=" + other_income + ", mortgage_interest="
				+ mortgage_interest + ", medical_expense=" + medical_expense + ", investment_income="
				+ investment_income + ", health_savings_account_contribution=" + health_savings_account_contribution
				+ ", form_1099=" + form_1099 + ", education_expense=" + education_expense + ", dependent_care_expense="
				+ dependent_care_expense + ", charitable_donation=" + charitable_donation + "]";
	}
		
}

