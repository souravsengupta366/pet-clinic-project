package com.sourav.petclinic.repositories;

import com.sourav.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Specialty,Long> {
}
