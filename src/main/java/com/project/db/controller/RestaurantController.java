package com.project.db.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.db.model.Restaurant;
import com.project.db.service.RestaurantService;

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

    @PostMapping
    public void createRestaurant( @RequestBody Restaurant restaurant ) 
    {
        service.addRestaurant( restaurant );
    }
}
