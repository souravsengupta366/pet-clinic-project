package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.repositories.VetRepository;
import com.sourav.petclinic.services.SpecialtyService;
import com.sourav.petclinic.services.VetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("jpa")
public class VetServicesJpa implements VetServices {
    private final SpecialtyService specialtyService;
    private final VetRepository vetRepository;

    public VetServicesJpa(SpecialtyService specialtyService, VetRepository vetRepository) {
        this.specialtyService = specialtyService;
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).get();
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return (Set<Vet>) vetRepository.findAll();
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
