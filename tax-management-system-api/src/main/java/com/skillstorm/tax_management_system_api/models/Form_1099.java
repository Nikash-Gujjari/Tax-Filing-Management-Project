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
public class Form_1099 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int form_1099_id;
	
	@Column
	private String form_name;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Form_1099(int form_1099_id, String form_name, Blob form, Tax_Return tax_return) {
		super();
		this.form_1099_id = form_1099_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getForm_1099_id() {
		return form_1099_id;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public void setForm_1099_id(int form_1099_id) {
		this.form_1099_id = form_1099_id;
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
		return "Form_1099 [form_1099_id=" + form_1099_id + ", form_name=" + form_name + ", form=" + form
				+ ", tax_return=" + tax_return + "]";
	}

	
}


