package com.skillstorm.tax_management_system_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Tax_return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int tax_return_id;
	
	@Column
	private String filing_status;
	
	@ManyToOne
	@JoinColumn(name="cpa", referencedColumnName = "cpa_id")
	@JsonIgnoreProperties("tax_return")
	private Cpa cpa;
	
	@OneToMany
	@JsonIgnoreProperties("tax_return")
	private List<Taxpayer> taxpayer;
	
	
	public Tax_return() {
		super();
	}

		
}

