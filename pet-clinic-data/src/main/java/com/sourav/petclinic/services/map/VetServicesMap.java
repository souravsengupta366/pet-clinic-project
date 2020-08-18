package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.SpecialtyService;
import com.sourav.petclinic.services.VetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"mapBased","default"})
@Service
public class VetServicesMap extends AbstractMap<Vet,Long> implements VetServices {

    private final SpecialtyService specialtyService;

    public VetServicesMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object != null){

           object.getSpecialties().forEach(specialty -> {
               if(specialty.getId() == null){
                    specialtyService.save(specialty);
               }
           });

            return super.save(object);
        }
        return  null;
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
