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
public class Retirement_Contribution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int retirement_contribution_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Retirement_Contribution(int retirement_contribution_id, String form_path, Tax_Return tax_return) {
		super();
		this.retirement_contribution_id = retirement_contribution_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getRetirement_contribution_id() {
		return retirement_contribution_id;
	}

	public void setRetirement_contribution_id(int retirement_contribution_id) {
		this.retirement_contribution_id = retirement_contribution_id;
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
		return "Retirement_Contribution [retirement_contribution_id=" + retirement_contribution_id + ", form_path="
				+ form_path + ", tax_return=" + tax_return + "]";
	}
	
}


