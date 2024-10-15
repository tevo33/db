package com.project.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.db.model.Restaurant;
import com.project.db.service.RestaurantService;

@RestController
@RequestMapping( "/api/restaurant" )
public class RestaurantController 
{
    @Autowired
    private RestaurantService service;
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Restaurant> getRestaurant( @PathVariable Long id ) 
    {
        Optional<Restaurant> restaurant = service.getRestaurant( id );
        return restaurant.map( ResponseEntity::ok )
                         .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping( "/all" )
    public ResponseEntity<List<Restaurant>> getRestaurants() 
    {
        List<Restaurant> restaurantList = service.getRestaurants();
        
        if ( restaurantList.isEmpty() ) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( restaurantList );
    }

    @PostMapping
    public void createRestaurant( @RequestBody Restaurant restaurant ) 
    {
        service.addRestaurant( restaurant );
    }
}