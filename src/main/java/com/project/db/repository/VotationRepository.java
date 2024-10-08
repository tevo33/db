package com.project.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.model.Votation;

public interface VotationRepository extends JpaRepository<Votation, Long>{}
