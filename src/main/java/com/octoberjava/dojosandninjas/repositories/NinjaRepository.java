package com.octoberjava.dojosandninjas.repositories;

import com.octoberjava.dojosandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
}
