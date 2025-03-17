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
public class Mortgage_Interest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int mortgage_interest_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_return tax_return;

	public Mortgage_Interest(int mortgage_interest_id, String form_path, Tax_return tax_return) {
		super();
		this.mortgage_interest_id = mortgage_interest_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getMortgage_interest_id() {
		return mortgage_interest_id;
	}

	public void setMortgage_interest_id(int mortgage_interest_id) {
		this.mortgage_interest_id = mortgage_interest_id;
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
		return "Mortgage_Interest [mortgage_interest_id=" + mortgage_interest_id + ", form_path=" + form_path
				+ ", tax_return=" + tax_return + "]";
	}

}


