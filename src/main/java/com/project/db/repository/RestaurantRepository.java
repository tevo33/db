package com.project.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}
