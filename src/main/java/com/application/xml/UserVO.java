package com.application.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class UserVO {
	
	@XmlAttribute
    private Integer id;

	@XmlElement
	private List<CompteBancaireVO> operationBancaires = new ArrayList<CompteBancaireVO>();
	 
    public List<CompteBancaireVO> getoperationBancaires() {
        return operationBancaires;
    }
 
    public UserVO(List<CompteBancaireVO> operationBancaires) {
        this.operationBancaires = operationBancaires;
    }
    public UserVO() {
	}

    public void setId(Integer id) {
		this.id = id;
	}
    public Integer getId() {
		return id;
	}
}
