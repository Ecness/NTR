package com.application.entity;

import javax.persistence.*;
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;
    public Authority() {}
    public Authority(AuthorityType name) {
        this.name = name;
    }
    public Integer getId() {
		return id;
	}
    public AuthorityType getName() {
		return name;
	}
    public void setId(Integer id) {
		this.id = id;
	}
    public void setName(AuthorityType name) {
		this.name = name;
	}
}