package com.sourav.petclinic.controller;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.model.Pet;
import com.sourav.petclinic.model.PetType;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller

public class PetController {

    private final OwnerServices ownerServices;
    private final PetTypeServices petTypeServices;

    public PetController(OwnerServices ownerServices, PetTypeServices petTypeServices) {
        this.ownerServices = ownerServices;
        this.petTypeServices = petTypeServices;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeServices.findAll();
    }

    @RequestMapping({"/pets","/pet","pets/index","pet/index","pets/index.html","pet/index.html"})
    public String index(){
        return "pets/index";
    }

    @GetMapping("/owners/{ownerId}/pets/new")
    public ModelAndView addPet(@PathVariable Long ownerId){
        Owner owner = ownerServices.findById(ownerId);
        Pet pet = new Pet();
        if(owner == null)
            throw new RuntimeException("There is no owner with the id: "+ownerId);
        pet.setOwner(owner);
        ModelAndView mv = new ModelAndView("pets/createOrUpdatePet");
        mv.addObject(pet);
        return  mv;
    }

    @PostMapping("/owners/{ownerId}/pets/new")
    public String addPet(@ModelAttribute Pet pet, @PathVariable Long ownerId) throws Exception{
        Owner owner = ownerServices.findById(ownerId);
        if(owner == null)
            throw new RuntimeException("There is no owner with the id: "+ownerId);
        try{
            System.out.println("pet is: "+pet.getName());
            System.out.println("Owner of the pet is: "+pet.getOwner().getFirstName());
        }catch (Exception e){
            System.out.println("error faced in printing segment of addPet");
            e.printStackTrace();
        }
        pet.setOwner(owner);
        owner.getPets().add(pet);
        ownerServices.save(owner);
        return "redirect:/owners/{ownerId}";
    }

    @GetMapping("owners/{ownerId}/pets/{petId}/edit")
    public ModelAndView petEdit(@PathVariable Long ownerId, @PathVariable Long petId){
        Owner owner = ownerServices.findById(ownerId);
        Pet pet = null;
        ModelAndView mv = new ModelAndView("pets/createOrUpdatePet");
        if(owner == null)
            throw new RuntimeException("There is no owner with the id: "+ownerId);
       for(Pet eachPet : owner.getPets()){
            if(eachPet.getId() == petId){
                pet = eachPet;
                break;
            }
       }
        if(pet == null)
            throw new RuntimeException("There is no pet with the id: "+petId+" for the owner id: "+ownerId);
        mv.addObject(pet);
        return mv;
    }

    @PostMapping("owners/{ownerId}/pets/{petId}/edit")
    public String petEdit(@ModelAttribute Pet pet, @PathVariable Long ownerId, @PathVariable Long petId){
        Owner owner = ownerServices.findById(ownerId);
        Pet curPet = owner.getPets().stream().filter(pets -> {
            if(pets.getId()==petId){
                return true;
            }
            return  false;
        }).findFirst()
        .orElse(null);

        if(curPet == null){
            System.out.println("There was no pet with the id: "+petId);
            owner.getPets().add(pet);
        }
        else{
            System.out.println("model pet:\n"+pet);
            System.out.println("existing pet:\n"+curPet);

            if(pet.getOwner() == null ) {
                System.out.println("The owner of the pet is null");
                pet.setOwner(owner);

            }
            if( !pet.getOwner().equals(owner)){
                System.out.println("The edited pet was not having the expected owner");
                pet.setOwner(owner);
            }
            if( pet.getVisit().size() == 0 && curPet.getVisit().size() !=  0){
                pet.setVisit(curPet.getVisit());
            }
            owner.getPets().removeIf(pet1 -> {
                if(pet1 == curPet)
                    return  true;
                return  false;
            });
            owner.getPets().add(pet);
        }


        ownerServices.save(owner);
        return "redirect:/owners/{ownerId}";
    }
}
