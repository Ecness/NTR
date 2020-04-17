package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer>{
   
}
