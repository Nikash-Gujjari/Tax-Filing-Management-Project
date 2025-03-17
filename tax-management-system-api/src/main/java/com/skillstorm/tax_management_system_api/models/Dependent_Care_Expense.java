package com.skillstorm.tax_management_system_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Dependent_Care_Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int dependent_care_expense_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnoreProperties("dependent_care_expense")
	private Tax_return tax_return;

	public Dependent_Care_Expense(int dependent_care_expense_id, String form_path, Tax_return tax_return) {
		super();
		this.dependent_care_expense_id = dependent_care_expense_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getDependent_care_expense_id() {
		return dependent_care_expense_id;
	}

	public void setDependent_care_expense_id(int dependent_care_expense_id) {
		this.dependent_care_expense_id = dependent_care_expense_id;
	}

	public String getForm_path() {
		return form_path;
	}

	public void setForm_path(String form_path) {
		this.form_path = form_path;
	}

	public Tax_return getTax_return() {
		return tax_return;
	}

	public void setTax_return(Tax_return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Dependent_Care_Expense [dependent_care_expense_id=" + dependent_care_expense_id + ", form_path="
				+ form_path + ", tax_return=" + tax_return + "]";
	}
	
}


