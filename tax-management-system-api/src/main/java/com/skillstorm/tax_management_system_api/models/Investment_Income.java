package com.skillstorm.tax_management_system_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Investment_Income {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int investment_income_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Investment_Income(int investment_income_id, String form_path, Tax_Return tax_return) {
		super();
		this.investment_income_id = investment_income_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getInvestment_income_id() {
		return investment_income_id;
	}

	public void setInvestment_income_id(int investment_income_id) {
		this.investment_income_id = investment_income_id;
	}

	public String getForm_path() {
		return form_path;
	}

	public void setForm_path(String form_path) {
		this.form_path = form_path;
	}

	public Tax_Return getTax_return() {
		return tax_return;
	}

	public void setTax_return(Tax_Return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Investment_Income [investment_income_id=" + investment_income_id + ", form_path=" + form_path
				+ ", tax_return=" + tax_return + "]";
	}

	
}


