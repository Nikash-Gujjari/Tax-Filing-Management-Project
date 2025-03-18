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
public class Unemployment_Benefit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int unemployment_benefit_id;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Unemployment_Benefit(int unemployment_benefit_id, Blob form, Tax_Return tax_return) {
		super();
		this.unemployment_benefit_id = unemployment_benefit_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getUnemployment_benefit_id() {
		return unemployment_benefit_id;
	}

	public void setUnemployment_benefit_id(int unemployment_benefit_id) {
		this.unemployment_benefit_id = unemployment_benefit_id;
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
		return "Unemployment_Benefit [unemployment_benefit_id=" + unemployment_benefit_id + ", tax_return=" + tax_return
				+ "]";
	}

	

	
}


