package com.project.db.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.db.model.Vote;
import com.project.db.repository.VoteRepository;

@Service
public class VoteService 
{
    private VoteRepository repository;
    
    private VoteService( VoteRepository repository )
    {
        this.repository = repository;
    }

    public ResponseEntity<Vote> getVote( Long id )
    {
        Optional<Vote> vote = repository.findById( id );

        return vote.map( ResponseEntity::ok )
                   .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    public void addVote( Vote vote )
    {
        repository.save( vote );
    }
}
