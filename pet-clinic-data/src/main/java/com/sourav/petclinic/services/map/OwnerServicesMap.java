package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Pet;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"mapBased","default"})
@Service
public class OwnerServicesMap extends AbstractMap<Owner,Long> implements OwnerServices {

    private  final PetTypeServices petTypeServices;
    private  final PetServices petServices ;

    public OwnerServicesMap(PetTypeServices petTypeServices, PetServices petServices){
        this.petTypeServices = petTypeServices;
        this.petServices= petServices;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
       if(object != null){
           object.getPets().forEach(pet ->{
               if(pet.getId() == null){
                   System.out.println("Owner saving");
                    if(pet.getType() != null && pet.getType().getId() == null)
                        pet.setType(petTypeServices.save(pet.getType()));
                    else if(pet.getType() == null)
                        throw new RuntimeException("pet type is null for the pet: "+pet.getName());
                    Pet savedPet = petServices.save(pet);
               }

           });
           System.out.println("Owner saved");
           return super.save(object);
       }
        return null;
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
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
