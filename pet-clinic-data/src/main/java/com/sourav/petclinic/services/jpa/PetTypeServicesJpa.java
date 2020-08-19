package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.PetType;
import com.sourav.petclinic.repositories.PetTypeRepository;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeServicesJpa implements PetTypeServices {
    private final PetTypeRepository petTypeRepository;

    public PetTypeServicesJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).get();
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public Set<PetType> findAll() {
        return (Set<PetType>)petTypeRepository.findAll();
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
