package com.project.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.db.model.Vote;
import com.project.db.repository.VoteRepository;

@Service
public class VoteService 
{
    @Autowired
    private VoteRepository repository;
    
    public Optional<Vote> getVote( Long id )
    {
        return repository.findById( id );
    }

    public void addVote( Vote vote )
    {
        repository.save( vote );
    }
}
