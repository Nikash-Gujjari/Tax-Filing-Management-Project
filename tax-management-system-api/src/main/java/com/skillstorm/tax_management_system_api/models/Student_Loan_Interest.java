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
public class Student_Loan_Interest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int student_loan_interest_id;
	
	@Column
	private String form_name;
	
	@Lob
	@Column
	private Blob form;
	
	@ManyToOne
	@JoinColumn(name="tax_return", referencedColumnName="tax_return_id")
	@JsonIgnore
	private Tax_Return tax_return;

	public Student_Loan_Interest(int student_loan_interest_id, String form_name, Blob form, Tax_Return tax_return) {
		super();
		this.student_loan_interest_id = student_loan_interest_id;
		this.form = form;
		this.tax_return = tax_return;
	}

	public int getStudent_loan_interest_id() {
		return student_loan_interest_id;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public void setStudent_loan_interest_id(int student_loan_interest_id) {
		this.student_loan_interest_id = student_loan_interest_id;
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
		return "Student_Loan_Interest [student_loan_interest_id=" + student_loan_interest_id + ", form_name="
				+ form_name + ", form=" + form + ", tax_return=" + tax_return + "]";
	}

}


