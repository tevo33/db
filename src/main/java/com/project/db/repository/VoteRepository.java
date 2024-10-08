package com.project.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{}