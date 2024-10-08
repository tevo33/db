package com.project.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.db.model.Restaurant;
import com.project.db.repository.RestaurantRepository;

@Service
public class RestaurantService 
{
    @Autowired
    private RestaurantRepository repository;
    
    public Optional<Restaurant> getRestaurant( Long id )
    {
        return repository.findById( id );
    }

    public void addRestaurant( Restaurant restaurant )
    {
        repository.save( restaurant );
    }
}
