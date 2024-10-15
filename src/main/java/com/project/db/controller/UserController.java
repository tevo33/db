package com.project.db.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.db.model.User;
import com.project.db.model.dtos.LoginRequest;
import com.project.db.service.UserService;

@RestController
@RequestMapping( "/api/user" )
public class UserController 
{
    @Autowired
    private UserService service;
    
    @GetMapping( "/{id}" )
    public ResponseEntity<User> getUser( @PathVariable Long id ) 
    {
        Optional<User> user = service.getUser( id );
        return user.map( ResponseEntity::ok )
                   .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PostMapping
    public void createUser( @RequestBody User user ) 
    {
        service.createUser( user );
    }

    @PostMapping( "/login" )
    public boolean verifyLogin( @RequestBody LoginRequest request ) 
    {
        return service.verifyLogin( request );
    }
}
