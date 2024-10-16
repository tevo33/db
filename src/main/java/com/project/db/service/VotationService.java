package com.project.db.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.db.model.Votation;
import com.project.db.repository.VotationRepository;

@Service
public class VotationService
{
    private VotationRepository repository;
    
    private VotationService( VotationRepository repository )
    {
        this.repository = repository;
    }

    public ResponseEntity<Votation> getVotation( Long id )
    {
        Optional<Votation> votation = repository.findById( id );

        return votation.map( ResponseEntity::ok )
                       .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    public void createVotation( Votation votation )
    {
        repository.save( votation );
    }
}
