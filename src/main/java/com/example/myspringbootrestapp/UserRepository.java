package com.example.myspringbootrestapp;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password); // Suche nach User wo email und password passt
    Optional<User> findBySecret(String secret); // Finde einen User mit dem Secret
}
