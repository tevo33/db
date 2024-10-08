package com.project.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
