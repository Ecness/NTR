package com.application.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.CompteBancaire;
import com.application.entity.User;

@Repository
public interface CompteRepository extends CrudRepository<CompteBancaire, Integer>{
   
}
