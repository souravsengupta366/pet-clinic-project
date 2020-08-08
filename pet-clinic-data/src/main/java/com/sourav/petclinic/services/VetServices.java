package com.sourav.petclinic.services;

import com.sourav.petclinic.model.Vet;

import java.util.Set;

public interface VetServices {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
