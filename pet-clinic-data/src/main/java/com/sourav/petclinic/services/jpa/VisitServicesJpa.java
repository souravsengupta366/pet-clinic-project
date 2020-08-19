package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Visit;
import com.sourav.petclinic.repositories.VisitRepository;
import com.sourav.petclinic.services.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("jpa")
public class VisitServicesJpa implements CrudService<Visit,Long> {
    private final VisitRepository  visitRepository;

    public VisitServicesJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).get();
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return (Set<Visit>) visitRepository.findAll();
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
