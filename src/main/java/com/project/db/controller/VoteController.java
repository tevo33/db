package com.project.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.project.db.model.Vote;
import com.project.db.service.VoteService;

@RestController
@RequestMapping( "/api/vote" )
public class VoteController 
{
    @Autowired
    private VoteService service;
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Vote> getVote( @PathVariable Long id ) 
    {
        Optional<Vote> vote = service.getVote( id );
        return vote.map( ResponseEntity::ok )
                   .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PostMapping
    public void addVote( @RequestBody Vote vote ) 
    {
        service.addVote( vote );
    }
}
