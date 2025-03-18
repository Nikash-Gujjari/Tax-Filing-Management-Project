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
	private int student_loan_interest_id;
	
	@Lob
	@Column
	private Blob form_path;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Charitable_Donation(int student_loan_interest_id, Blob form_path, Tax_Return tax_return) {
		super();
		this.student_loan_interest_id = student_loan_interest_id;
		this.form_path = form_path;
		this.tax_return = tax_return;
	}

	public int getStudent_loan_interest_id() {
		return student_loan_interest_id;
	}

	public void setStudent_loan_interest_id(int student_loan_interest_id) {
		this.student_loan_interest_id = student_loan_interest_id;
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
		return "Charitable_Donation [student_loan_interest_id=" + student_loan_interest_id + ", form_path=" + form_path
				+ ", tax_return=" + tax_return + "]";
	}

	

}


