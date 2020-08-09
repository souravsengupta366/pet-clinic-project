package com.sourav.petclinic.bootstrap;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.VetServices;
import com.sourav.petclinic.services.map.OwnerServicesMap;
import com.sourav.petclinic.services.map.VetServicesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    @Autowired
    DataLoader(OwnerServices ownerServices, VetServices vetServices){
        this.ownerServices = new OwnerServicesMap();
        this.vetServices = new VetServicesMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sourav");
        owner1.setLastName("Sengupta");
        ownerServices.save(owner1.getId(),owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Gaurabh");
        owner1.setLastName("Sengupta");
        ownerServices.save(owner2.getId(),owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Uma");
        vet1.setLastName("Sengupta");
        vetServices.save(vet1.getId(),vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Akansha");
        vet1.setLastName("Sengupta");
        vetServices.save(vet2.getId(),vet2);

        System.out.println("Data has been loaded for Owners and Vets");
        System.out.println("Owner services size: "+ownerServices.findAll().size()+" VetServices size: "+ vetServices.findAll().size());

    }
}
