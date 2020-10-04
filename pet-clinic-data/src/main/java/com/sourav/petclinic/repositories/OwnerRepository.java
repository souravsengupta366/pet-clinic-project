package com.sourav.petclinic.repositories;

import com.sourav.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

    public Set<Optional<Owner>> findByLastName(String lastName);
    public Optional<Owner> findById(Long id);
    public Set<Optional<Owner>> findByFirstName(String firstName);

}
