package com.skillstorm.tax_management_system_api.models;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Retirement_Income {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int retirement_income_id;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Retirement_Income(int retirement_income_id, Blob form, Tax_Return tax_return) {
		super();
		this.retirement_income_id = retirement_income_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getRetirement_income_id() {
		return retirement_income_id;
	}

	public void setRetirement_income_id(int retirement_income_id) {
		this.retirement_income_id = retirement_income_id;
	}

	public Blob getForm() {
		return form;
	}

	public void setForm(Blob form) {
		this.form = form;
	}

	public Tax_Return getTax_return() {
		return tax_return;
	}

	public void setTax_return(Tax_Return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "Retirement_Income [retirement_income_id=" + retirement_income_id + ", form=" + form + ", tax_return="
				+ tax_return + "]";
	}

	
}


