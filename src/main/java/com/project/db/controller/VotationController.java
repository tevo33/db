package com.project.db.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.db.model.Votation;
import com.project.db.service.VotationService;

@RestController
@RequestMapping( "/api/votation" )
public class VotationController 
{
    private VotationService service;
    
    private VotationController( VotationService service )
    {
        this.service = service;
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Votation> getVotation( @PathVariable Long id ) 
    {
        return service.getVotation( id );
    }

    @PostMapping
    public void createVotation( @RequestBody Votation votation ) 
    {
        service.createVotation( votation );
    }
}
