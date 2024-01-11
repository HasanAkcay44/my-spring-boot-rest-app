package com.example.myspringbootrestapp;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

// Type ist Todo und Id ist Integer
public interface TodoRepository extends CrudRepository<Todo, Integer> {

    Set<Todo> findAllByUserId(int userId);

}
