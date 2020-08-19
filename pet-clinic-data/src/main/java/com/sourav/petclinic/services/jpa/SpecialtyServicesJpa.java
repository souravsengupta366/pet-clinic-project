package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Specialty;
import com.sourav.petclinic.repositories.SpecialityRepository;
import com.sourav.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("jpa")
public class SpecialtyServicesJpa implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialtyServicesJpa(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Specialty findById(Long id) {
        return specialityRepository.findById(id).get();
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialityRepository.save(specialty);
    }

    @Override
    public Set<Specialty> findAll() {
        return ( Set<Specialty>) specialityRepository.findAll();
    }

    @Override
    public void delete(Specialty specialty) {
        specialityRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);

    }
}
