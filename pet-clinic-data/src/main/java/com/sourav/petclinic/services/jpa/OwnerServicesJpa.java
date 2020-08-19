package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.repositories.OwnerRepository;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Profile({"jpa"})
@Service
public class OwnerServicesJpa implements OwnerServices {

    private final PetTypeServices petTypeServices;
    private final PetServices petServices;
    private final OwnerRepository ownerRepository;

    public OwnerServicesJpa(PetTypeServices petTypeServices, PetServices petServices, OwnerRepository ownerRepository) {
        this.petTypeServices = petTypeServices;
        this.petServices = petServices;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).get();
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        return (Set<Owner>) ownerRepository.findAll();
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
