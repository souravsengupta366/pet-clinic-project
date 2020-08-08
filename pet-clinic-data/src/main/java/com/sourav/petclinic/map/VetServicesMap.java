package com.sourav.petclinic.map;

import com.sourav.petclinic.model.Vet;

import java.util.Set;

public class VetServicesMap extends AbstractMap<Vet,Long> {
    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Long aLong, Vet object) {
        return super.save(aLong, object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
