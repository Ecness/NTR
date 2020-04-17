package com.application.xml;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.application.entity.CompteBancaire;
import com.application.entity.Operation;


@XmlRootElement (name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class CompteBancaireVO {
	
	@XmlAttribute
	private Integer idCompte;
	
	@XmlElement
	private Double total;
	@XmlElement
	private List<OperationVO> operationBancaires = new ArrayList<OperationVO>();
	
    public CompteBancaireVO(int id , List<OperationVO> operationBancaires) {
        this.operationBancaires = operationBancaires;
        setIdCompte(id);
    }
    public CompteBancaireVO() {
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
	public List<OperationVO> getOperationBancaires() {
		return operationBancaires;
	}
	public void setOperationBancaires(List<OperationVO> operationBancaires) {
		this.operationBancaires = operationBancaires;
	}
}
