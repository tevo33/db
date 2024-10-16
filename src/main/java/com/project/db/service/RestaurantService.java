package com.project.db.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.db.model.Restaurant;
import com.project.db.repository.RestaurantRepository;

@Service
public class RestaurantService 
{
    private RestaurantRepository repository;

    private RestaurantService( RestaurantRepository repository )
    {
        this.repository = repository;
    }
    
    public ResponseEntity<Restaurant> getRestaurant( Long id )
    {
        return repository.findById( id ).map( ResponseEntity::ok )
                         .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    public ResponseEntity<List<Restaurant>> getRestaurants()
    {
        List<Restaurant> restaurantList = repository.findAll();
        
        if ( restaurantList.isEmpty() ) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( restaurantList );
    }

    public void addRestaurant( Restaurant restaurant )
    {
        repository.save( restaurant );
    }
}
