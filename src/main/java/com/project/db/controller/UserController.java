package com.project.db.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private UserService service;

    private UserController( UserService service )
    {
        this.service = service;
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> getUser( @PathVariable Long id ) 
    {
        return service.getUser( id );
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> getUsers() 
    {
        return service.getUsers();
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

    @DeleteMapping( "/{id}" )
    public void deleteUser( @PathVariable Long id ) 
    {
        service.deleteUser( id );
    }
}
