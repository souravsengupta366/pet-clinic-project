package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.VetServices;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class VetServicesMap extends AbstractMap<Vet,Long> implements VetServices {
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
