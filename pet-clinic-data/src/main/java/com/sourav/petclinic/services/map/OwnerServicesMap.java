package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.services.OwnerServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServicesMap extends AbstractMap<Owner,Long> implements OwnerServices {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Long aLong, Owner object) {
        return super.save(aLong, object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
