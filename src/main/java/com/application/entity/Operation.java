package com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity 
@Table(name = "OPERATION")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_OPERATION", nullable = false, length = 10)
	private Integer idOperation;
	
	@Column(name = "SOMME", nullable = true, length = 5)
	private Double somme;
	
	@Column(name = "OPERATION", nullable = false, length = 256)
	private String operation;

	public Operation(double somme, String operation) {
		setSomme(somme);
		setOperation(operation);
	}
	
	public Operation() {
		this(0, OperationType.AUTRE.toString());
	}


	public Integer getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}
	public Double getSomme() {
		return somme;
	}
	public void setSomme(Double total) {
		this.somme = total;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
