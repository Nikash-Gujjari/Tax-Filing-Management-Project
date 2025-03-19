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
public class Charitable_Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int charitable_donation_id;
	
	@Column
	private String form_name;
	
	@Lob
	@Column
	private Blob form_path;
	

	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Charitable_Donation(int charitable_donation_id, String form_name, Blob form_path, Tax_Return tax_return) {
		super();
		this.charitable_donation_id = charitable_donation_id;
		this.form_name = form_name;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getCharitable_donation_id() {
		return charitable_donation_id;
	}

	public void setCharitable_donation_id(int charitable_donation_id) {
		this.charitable_donation_id = charitable_donation_id;
	}


	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}


	public Blob getForm_path() {
		return form_path;
	}

	public void setForm_path(Blob form_path) {
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
		return "Charitable_Donation [charitable_donation_id=" + charitable_donation_id + ", form_name=" + form_name
				+ ", form_path=" + form_path + ", tax_return=" + tax_return + "]";
	}

	

}


