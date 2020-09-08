package com.sourav.petclinic.bootstrap;

import com.sourav.petclinic.model.*;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetTypeServices;
import com.sourav.petclinic.services.SpecialtyService;
import com.sourav.petclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeServices petTypeServices;
    private final SpecialtyService specialtyService;

//    @Autowired // From spring5, for constructors like below, you donot need to mention @Autowired as spring automatically reads it like that
    DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeServices petTypeServices, SpecialtyService specialtyService){
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeServices = petTypeServices;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeServices.findAll().size() == 0)
         loadData();

    }

    private void loadData() {
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
        Vet savedVetUma = vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Akansha");
        vet2.setLastName("Sengupta");
        Vet savedVetAkansha = vetServices.save(vet2);

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("radiology");
        Specialty savedSpecialtyRadiology = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("surgery");
        Specialty savedSpecialtySurgery = specialtyService.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("dentistry");
        Specialty savedSpecialtyDentistry = specialtyService.save(specialty3);

        savedVetUma.getSpecialties().add(savedSpecialtyDentistry);
        savedVetAkansha.getSpecialties().add(savedSpecialtyRadiology);
        savedVetAkansha.getSpecialties().add(savedSpecialtySurgery);
        /** Since I am saving the same variable which was returned from the save method, it will not create a new entry
         * in the table, rather it will update it**/
        savedVetUma.setLastName("Dasgupta");
        vetServices.save(savedVetAkansha);
        vetServices.save(savedVetUma);



/**** Testing starts below *****/
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

        System.out.println("The total number of specialties are: ");
        specialtyService.findAll().forEach(specialty -> {
            System.out.println(specialty.getId()+". "+specialty.getDescription());
        });
        System.out.println("#### Vets #####");
        vetServices.findAll().forEach(vet -> {
            System.out.println(vet.getId()+". "+"Specialities of Vet: "+vet.getFirstName() +" is/are:");
            vet.getSpecialties().forEach(specialty -> System.out.println(specialty.getId()+". "+specialty.getDescription()));
        });
    }
}
