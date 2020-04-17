package com.application.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class OperationVO {
	
	@XmlAttribute
	private Integer idOperation;
	
	@XmlElement
	private Double somme;
	@XmlElement
	private String operation;
	
	public OperationVO(int id, double somme, String operation) {
		setIdOperation(id);
		setSomme(somme);
		setOperation(operation);
	}
	
	public OperationVO() {
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
