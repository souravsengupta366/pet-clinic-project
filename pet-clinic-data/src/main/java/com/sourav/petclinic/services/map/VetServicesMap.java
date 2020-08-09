package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.VetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"mapBased","default"})
@Service
public class VetServicesMap extends AbstractMap<Vet,Long> implements VetServices {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
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
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
