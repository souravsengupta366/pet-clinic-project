package com.sourav.petclinic.bootstrap;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Pet;
import com.sourav.petclinic.model.PetType;
import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetTypeServices;
import com.sourav.petclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeServices petTypeServices;

//    @Autowired // From spring5, for constructors like below, you donot need to mention @Autowired as spring automatically reads it like that
    DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeServices petTypeServices){
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeServices = petTypeServices;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeServices.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeServices.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sourav");
        owner1.setLastName("Sengupta");
        owner1.setAddress("145 Briji West, Garia, 700084");
        owner1.setCity("Kolkata");
        owner1.setPhone("1232312343");
        Owner savedOwnerSourav = ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gaurabh");
        owner2.setLastName("Sengupta");
        owner2.setAddress("NH 87, Karnataka");
        owner2.setCity("Bangalore");
        owner2.setPhone("1232312343");
        Owner savedOwnerGaurabh = ownerServices.save(owner2);

        Pet ssgPet = new Pet();
        ssgPet.setType(savedDogPetType);
        ssgPet.setBirthDate(LocalDate.now());
        ssgPet.setName("Chiku");
        ssgPet.setOwner(savedOwnerSourav);
        savedOwnerSourav.getPets().add(ssgPet);
        ownerServices.save(savedOwnerSourav);


        Pet grbPet = new Pet();
        grbPet.setType(savedCatPetType);
        grbPet.setBirthDate(LocalDate.now());
        grbPet.setName("Piku");
        grbPet.setOwner(savedOwnerGaurabh);
        savedOwnerGaurabh.getPets().add(grbPet);
        ownerServices.save(savedOwnerGaurabh);

        Vet vet1 = new Vet();
        vet1.setFirstName("Uma");
        vet1.setLastName("Sengupta");
        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Akansha");
        vet2.setLastName("Sengupta");
        vetServices.save(vet2);

        System.out.println("Data has been loaded for Owners and Vets");
        System.out.println("Owner services size: "+ownerServices.findAll().size()+" \nVetServices size: "+ vetServices.findAll().size());
        System.out.println("Pet Type Services size: "+petTypeServices.findAll().size());
        System.out.println("Sourav has "+savedOwnerSourav.getPets().size()+" pet/s. Sourav's pet/s are: ");
        savedOwnerSourav.getPets().forEach(pet -> {
            System.out.print(pet.getName() +" with an id "+pet.getId()+" and pet type:"+ pet.getType().getName()+" with pettype id:" +
                    pet.getType().getId() +"\n");
        });
        System.out.println("Gaurabh's pets are: ");
        savedOwnerGaurabh.getPets().forEach(pet -> {
            System.out.print(pet.getName() +" with an id "+pet.getId()+" and pet type:"+ pet.getType().getName()+" with pettype id:" +
                    pet.getType().getId() +"\n");
        });

    }
}
