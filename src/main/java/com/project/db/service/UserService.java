package com.project.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.db.model.Restaurant;
import com.project.db.model.User;
import com.project.db.model.dtos.LoginRequest;
import com.project.db.repository.UserRepository;

@Service
public class UserService 
{
    private UserRepository repository;
    
    private UserService( UserRepository repository )
    {
        this.repository = repository;
    }

    public ResponseEntity<User> getUser( Long id )
    {
        Optional<User> user = repository.findById( id );
        
        return user.map( ResponseEntity::ok )
                   .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    public ResponseEntity<List<User>> getUsers()
    {
        List<User> userList = repository.findAll();
        
        if ( userList.isEmpty() ) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( userList );
    }

    public void createUser( User user )
    {
        repository.save( user );
    }

    public boolean verifyLogin( LoginRequest request ) 
    {
        User user = repository.findByName( request.login() ).orElse(null);
        
        if ( user != null )
        {
            return user.getPassword().equals( request.senha() );
        }

        return false;
    }

    public void deleteUser( Long id ) 
    {
        repository.deleteById(id);
    }
}
