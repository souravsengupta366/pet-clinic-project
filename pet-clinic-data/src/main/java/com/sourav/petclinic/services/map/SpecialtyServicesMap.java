package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Specialty;
import com.sourav.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"mapBased","default"})
public class SpecialtyServicesMap extends AbstractMap<Specialty,Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Long getNextId() {
        return super.getNextId();
    }
}
