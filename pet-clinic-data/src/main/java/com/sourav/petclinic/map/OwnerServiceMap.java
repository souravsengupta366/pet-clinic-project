package com.sourav.petclinic.map;

import com.sourav.petclinic.model.Owner;

import java.util.Set;

public class OwnerServiceMap extends AbstractMap<Owner,Long>{
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
