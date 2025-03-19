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
public class W2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int w2_id;
	
	@Column
	private String form_name;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public W2(int w2_id, String form_name, Blob form, Tax_Return tax_return) {
		super();
		this.w2_id = w2_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getW2_id() {
		return w2_id;
	}

	public void setW2_id(int w2_id) {
		this.w2_id = w2_id;
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

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public void setTax_return(Tax_Return tax_return) {
		this.tax_return = tax_return;
	}

	@Override
	public String toString() {
		return "W2 [w2_id=" + w2_id + ", form_name=" + form_name + ", form=" + form + ", tax_return=" + tax_return
				+ "]";
	}

	
}


