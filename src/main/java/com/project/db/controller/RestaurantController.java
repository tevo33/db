package com.project.db.controller;

import java.util.List;
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
    private RestaurantService service;

    private RestaurantController( RestaurantService service )
    {
        this.service = service;
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Restaurant> getRestaurant( @PathVariable Long id ) 
    {
        return service.getRestaurant( id ); 
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getRestaurants() 
    {
        return service.getRestaurants();
    }

    @PostMapping
    public void createRestaurant( @RequestBody Restaurant restaurant ) 
    {
        service.addRestaurant( restaurant );
    }
}