package com.sourav.petclinic.bootstrap;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerServices ownerServices;
    private final VetServices vetServices;

//    @Autowired // From spring5, for constructors like below, you donot need to mention @Autowired as spring automatically reads it like that
    DataLoader(OwnerServices ownerServices, VetServices vetServices){
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Sourav");
        owner1.setLastName("Sengupta");
        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gaurabh");
        owner2.setLastName("Sengupta");
        ownerServices.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Uma");
        vet1.setLastName("Sengupta");
        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Akansha");
        vet2.setLastName("Sengupta");
        vetServices.save(vet2);

        System.out.println("Data has been loaded for Owners and Vets");
        System.out.println("Owner services size: "+ownerServices.findAll().size()+" VetServices size: "+ vetServices.findAll().size());

    }
}
