package com.application.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity 
@Table(name = "COMPTE")
public class CompteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COMPTE", nullable = false, length = 10)
	private Integer idCompte;
	
	@Column(name = "TOTAL", nullable = true, length = 5)
	private Double total;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Operation> operationBancaires;
	
	public CompteBancaire(double total) {
		setTotal(total);
		setOperationBancaires(new ArrayList<Operation>());
	}
	
	public CompteBancaire() {
		this(0);
	}

	public void setHouse(CompteBancaire compte) {
		setTotal(compte.getTotal());
	}
	
	public Integer getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<Operation> getOperationBancaires() {
		return operationBancaires;
	}
	public void setOperationBancaires(List<Operation> operationBancaires) {
		this.operationBancaires = operationBancaires;
	}
}
