package com.sourav.petclinic.repositories;

import com.sourav.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

    public Optional<Owner> findByLastName(String lastName);
    public Optional<Owner> findById(Long id);

}
