package com.skillstorm.tax_management_system_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class W2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int w2_id;
	
	@Column
	private String form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnoreProperties("w2")
	private Tax_return tax_return;

	public W2(int w2_id, String form_path, Tax_return tax_return) {
		super();
		this.w2_id = w2_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getW2_id() {
		return w2_id;
	}

	public void setW2_id(int w2_id) {
		this.w2_id = w2_id;
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
		return "W2 [w2_id=" + w2_id + ", form_path=" + form_path + ", tax_return=" + tax_return + "]";
	}
	
}


