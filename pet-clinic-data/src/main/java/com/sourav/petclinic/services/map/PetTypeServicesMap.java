package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.PetType;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"mapBased","default"})
@Service
public class PetTypeServicesMap extends AbstractMap<PetType,Long> implements PetTypeServices {
    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Long getNextId() {
        return super.getNextId();
    }
}
