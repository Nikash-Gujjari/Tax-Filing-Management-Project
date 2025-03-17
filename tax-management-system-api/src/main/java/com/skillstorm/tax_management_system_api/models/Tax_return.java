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
public class Tax_return {
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
	private W2 w2;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Unemployment_Benefit unemployment_benefit;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Student_Loan_Interest student_loan_interest;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private State_Tax state_tax;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Local_Tax local_tax;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Retirement_Income retirement_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Retirement_Contribution retirement_contribution;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Other_Income other_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Mortgage_Interest mortgage_interest;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Medical_Expense medical_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Investment_Income investment_income;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Health_Savings_Account_Contribution health_savings_account_contribution;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Form_1099 form_1099;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Education_Expense education_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Dependent_Care_Expense dependent_care_expense;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private Charitable_Donation charitable_donation;
	
	
	public Tax_return() {
		super();
	}


	public Tax_return(int tax_return_id, String filing_status, Cpa cpa, List<Taxpayer> taxpayer, W2 w2,
			Unemployment_Benefit unemployment_benefit, Student_Loan_Interest student_loan_interest, State_Tax state_tax,
			Local_Tax local_tax, Retirement_Income retirement_income, Retirement_Contribution retirement_contribution,
			Other_Income other_income, Mortgage_Interest mortgage_interest, Medical_Expense medical_expense,
			Investment_Income investment_income,
			Health_Savings_Account_Contribution health_savings_account_contribution, Form_1099 form_1099,
			Education_Expense education_expense, Dependent_Care_Expense dependent_care_expense,
			Charitable_Donation charitable_donation) {
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


	public W2 getW2() {
		return w2;
	}


	public void setW2(W2 w2) {
		this.w2 = w2;
	}


	public Unemployment_Benefit getUnemployment_benefit() {
		return unemployment_benefit;
	}


	public void setUnemployment_benefit(Unemployment_Benefit unemployment_benefit) {
		this.unemployment_benefit = unemployment_benefit;
	}


	public Student_Loan_Interest getStudent_loan_interest() {
		return student_loan_interest;
	}


	public void setStudent_loan_interest(Student_Loan_Interest student_loan_interest) {
		this.student_loan_interest = student_loan_interest;
	}


	public State_Tax getState_tax() {
		return state_tax;
	}


	public void setState_tax(State_Tax state_tax) {
		this.state_tax = state_tax;
	}


	public Local_Tax getLocal_tax() {
		return local_tax;
	}


	public void setLocal_tax(Local_Tax local_tax) {
		this.local_tax = local_tax;
	}


	public Retirement_Income getRetirement_income() {
		return retirement_income;
	}


	public void setRetirement_income(Retirement_Income retirement_income) {
		this.retirement_income = retirement_income;
	}


	public Retirement_Contribution getRetirement_contribution() {
		return retirement_contribution;
	}


	public void setRetirement_contribution(Retirement_Contribution retirement_contribution) {
		this.retirement_contribution = retirement_contribution;
	}


	public Other_Income getOther_income() {
		return other_income;
	}


	public void setOther_income(Other_Income other_income) {
		this.other_income = other_income;
	}


	public Mortgage_Interest getMortgage_interest() {
		return mortgage_interest;
	}


	public void setMortgage_interest(Mortgage_Interest mortgage_interest) {
		this.mortgage_interest = mortgage_interest;
	}


	public Medical_Expense getMedical_expense() {
		return medical_expense;
	}


	public void setMedical_expense(Medical_Expense medical_expense) {
		this.medical_expense = medical_expense;
	}


	public Investment_Income getInvestment_income() {
		return investment_income;
	}


	public void setInvestment_income(Investment_Income investment_income) {
		this.investment_income = investment_income;
	}


	public Health_Savings_Account_Contribution getHealth_savings_account_contribution() {
		return health_savings_account_contribution;
	}


	public void setHealth_savings_account_contribution(
			Health_Savings_Account_Contribution health_savings_account_contribution) {
		this.health_savings_account_contribution = health_savings_account_contribution;
	}


	public Form_1099 getForm_1099() {
		return form_1099;
	}


	public void setForm_1099(Form_1099 form_1099) {
		this.form_1099 = form_1099;
	}


	public Education_Expense getEducation_expense() {
		return education_expense;
	}


	public void setEducation_expense(Education_Expense education_expense) {
		this.education_expense = education_expense;
	}


	public Dependent_Care_Expense getDependent_care_expense() {
		return dependent_care_expense;
	}


	public void setDependent_care_expense(Dependent_Care_Expense dependent_care_expense) {
		this.dependent_care_expense = dependent_care_expense;
	}


	public Charitable_Donation getCharitable_donation() {
		return charitable_donation;
	}


	public void setCharitable_donation(Charitable_Donation charitable_donation) {
		this.charitable_donation = charitable_donation;
	}


	@Override
	public String toString() {
		return "Tax_return [tax_return_id=" + tax_return_id + ", filing_status=" + filing_status + ", cpa=" + cpa
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

