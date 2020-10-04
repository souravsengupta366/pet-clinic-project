package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.exceptionClasses.NotFoundException;
import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.repositories.OwnerRepository;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public Set<Owner> findByLastName(String lastName) {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findByLastName(lastName).forEach(optionalOwner -> ownerSet.add(optionalOwner.get()));
        return ownerSet;
    }

    @Override
    public Set<Owner> findByFirstName(String firstName) {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findByFirstName(firstName).forEach(optionalOwner -> ownerSet.add(optionalOwner.get()));
        return ownerSet;
    }

    @Override
    public Owner findById(Long id) {
         if(ownerRepository.findById(id).isPresent()) {
             return ownerRepository.findById(id).get();
         }
         else{
             throw new NotFoundException("There is no Owner with the id: "+id);
         }
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        return owners;
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
