package com.application.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9067986418908847017L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false, unique = true, length = 256)
    private String username;
    @NotEmpty
    @Column(nullable = false, length = 256)
    private String password;

    @Column(name = "NAME", nullable = false, length = 256)
	@NotNull(message = "ID Name can not be null")
	@NotBlank(message = "ID Name can not be empty")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CompteBancaire> compteBancaires;
	
    @ManyToMany( cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") })
    private Set<Authority> authorities = new HashSet<>();

    public User() {
    }
    public User( String username,String password,String name,Set<Authority> authorities) {
    	setName(name);
    	setPassword(password);
    	setUsername(username);
    	setAuthorities(authorities);
		setCompteBancaires(new ArrayList<CompteBancaire>());
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
		return name;
	}
    public void setCompteBancaires(List<CompteBancaire> compteBancaires) {
		this.compteBancaires = compteBancaires;
	}
    public List<CompteBancaire> getCompteBancaires() {
		return compteBancaires;
	}
    public void setName(String name) {
		this.name = name;
	}

}