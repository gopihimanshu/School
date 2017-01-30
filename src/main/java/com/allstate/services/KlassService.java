package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {

    private IKlassRepository repository;

    @Autowired
    public KlassService(IKlassRepository repository) { this.repository = repository; }


    public Klass create(Klass klass){
        return this.repository.save(klass);
    }

    public Klass findById(int id){
        return this.repository.findOne(id);
    }

    public Klass findByName(String name){
        return this.repository.findByName(name);
    }
}