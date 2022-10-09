package com.octoberjava.dojosandninjas.services;

import com.octoberjava.dojosandninjas.models.Dojo;
import com.octoberjava.dojosandninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAll() {
        return (List<Dojo>) dojoRepository.findAll();
    }

    public void create(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    public Dojo getOne(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);

    }
}
