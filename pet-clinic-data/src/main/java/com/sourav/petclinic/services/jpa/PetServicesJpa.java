package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Pet;
import com.sourav.petclinic.repositories.PetRepository;
import com.sourav.petclinic.services.PetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("jpa")
public class PetServicesJpa implements PetServices {

    private final PetRepository petRepository;

    public PetServicesJpa(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> findAll() {
        return (Set<Pet>) petRepository.findAll();
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
