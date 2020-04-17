package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);
}