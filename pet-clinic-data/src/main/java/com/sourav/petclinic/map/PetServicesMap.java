package com.sourav.petclinic.map;

import com.sourav.petclinic.model.Pet;

import java.util.Set;

public class PetServicesMap extends AbstractMap<Pet,Long> {
    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pet save(Long aLong, Pet object) {
        return super.save(aLong, object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
