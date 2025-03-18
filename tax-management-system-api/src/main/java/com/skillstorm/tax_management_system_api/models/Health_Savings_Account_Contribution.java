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
public class Health_Savings_Account_Contribution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int health_savings_account_contribution_id;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Health_Savings_Account_Contribution(int health_savings_account_contribution_id, Blob form,
			Tax_Return tax_return) {
		super();
		this.health_savings_account_contribution_id = health_savings_account_contribution_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getHealth_savings_account_contribution_id() {
		return health_savings_account_contribution_id;
	}

	public void setHealth_savings_account_contribution_id(int health_savings_account_contribution_id) {
		this.health_savings_account_contribution_id = health_savings_account_contribution_id;
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
		return "Health_Savings_Account_Contribution [health_savings_account_contribution_id="
				+ health_savings_account_contribution_id + ", tax_return=" + tax_return + "]";
	}

	

}


