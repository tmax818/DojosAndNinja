package com.octoberjava.dojosandninjas.services;

import com.octoberjava.dojosandninjas.models.Ninja;
import com.octoberjava.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void create(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}
