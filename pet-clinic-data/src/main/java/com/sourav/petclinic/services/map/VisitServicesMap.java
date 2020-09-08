package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Pet;
import com.sourav.petclinic.model.Visit;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.VisitServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"mapBased","default"})
@Service
public class VisitServicesMap extends AbstractMap<Visit,Long> implements VisitServices {

    private final OwnerServices ownerServices;
    private final PetServices petServices;

    public VisitServicesMap(OwnerServices ownerServices, PetServices petServices) {
        this.ownerServices = ownerServices;
        this.petServices = petServices;
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        try {
            if (visit != null) {
                Owner owner = visit.getOwner();
                Pet pet = visit.getPet();
                if (owner != null && owner.getId() == null) {
                    ownerServices.save(owner);
                }

                if (pet != null && pet.getId() == null)
                    petServices.save(pet);

                if (owner == null || pet == null) {
                    throw new RuntimeException("Cannot have null values for owner and pet");
                }

                return super.save(visit);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
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
