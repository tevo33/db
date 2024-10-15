package com.project.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    Optional<User> findByName(String name);
}
