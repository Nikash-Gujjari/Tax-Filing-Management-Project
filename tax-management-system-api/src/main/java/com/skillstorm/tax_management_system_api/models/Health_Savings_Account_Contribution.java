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
public class Health_Savings_Account_Contribution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int health_savings_account_contribution_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_return tax_return;

	public Health_Savings_Account_Contribution(int health_savings_account_contribution_id, String form_path,
			Tax_return tax_return) {
		super();
		this.health_savings_account_contribution_id = health_savings_account_contribution_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getHealth_savings_account_contribution_id() {
		return health_savings_account_contribution_id;
	}

	public void setHealth_savings_account_contribution_id(int health_savings_account_contribution_id) {
		this.health_savings_account_contribution_id = health_savings_account_contribution_id;
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
		return "Health_Savings_Account_Contribution [health_savings_account_contribution_id="
				+ health_savings_account_contribution_id + ", form_path=" + form_path + ", tax_return=" + tax_return
				+ "]";
	}

}


