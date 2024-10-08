package com.project.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.db.model.User;
import com.project.db.repository.UserRepository;

@Service
public class UserService 
{
    @Autowired
    private UserRepository repository;
    
    public Optional<User> getUser( Long id )
    {
        return repository.findById( id );
    }

    public void createUser( User user )
    {
        repository.save( user );
    }
}
