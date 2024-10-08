package com.project.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.db.model.Votation;
import com.project.db.repository.VotationRepository;

@Service
public class VotationService
{
    @Autowired
    private VotationRepository repository;
    
    public Optional<Votation> getVotation( Long id )
    {
        return repository.findById( id );
    }

    public void createVotation( Votation votation )
    {
        repository.save( votation );
    }
}
