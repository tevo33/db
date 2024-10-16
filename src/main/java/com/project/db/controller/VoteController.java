package com.project.db.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.db.model.Vote;
import com.project.db.service.VoteService;

@RestController
@RequestMapping( "/api/vote" )
public class VoteController 
{
    private VoteService service;

    private VoteController( VoteService service )
    {
        this.service = service;
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Vote> getVote( @PathVariable Long id ) 
    {
        return service.getVote( id );
    }

    @PostMapping
    public void addVote( @RequestBody Vote vote ) 
    {
        service.addVote( vote );
    }
}
