package com.sourav.petclinic.controller;

import com.sourav.petclinic.model.*;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.VetServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits/")
public class VisitController {

    private final PetServices petServices;
    private final OwnerServices ownerServices;
    private final VetServices vetServices;

    public VisitController(PetServices petServices, OwnerServices ownerServices, VetServices vetServices) {
        this.petServices = petServices;
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
    }

    @ModelAttribute("vets")
    public Collection<Vet> populateVets() {
        return vetServices.findAll();
    }

    @GetMapping("new")
    public String addVisit (@PathVariable Long ownerId, @PathVariable Long petId, Model model) throws Exception{
        Visit visit = new Visit();
        Pet pet = petServices.findById(petId);
        System.out.println("pet name is: "+pet.getName());
        Owner owner = ownerServices.findById(ownerId);
        if(owner == null)
            throw new RuntimeException("No owner found with the id: "+ownerId);
        if(pet == null)
            throw new RuntimeException("No pet found with the id: "+petId);
        visit.setOwner(owner);
        visit.setPet(pet);
        System.out.println(visit.getPet().getName());
        model.addAttribute("visit",visit);
        model.addAttribute("pet",pet);
        model.addAttribute("owner",owner);
//        model.addAttribute("vets",vetServices.findAll());
        return "pets/createOrUpdateVisit";
    }

    @PostMapping("new")
    public String addVisit (@PathVariable Long ownerId, @PathVariable Long petId, @ModelAttribute Visit visit) throws Exception{
        Owner owner = ownerServices.findById(ownerId);
        Pet pet = petServices.findById(petId);
        if(visit.getOwner() == null){
            System.out.println("Visit had no owner. \n Setting owner to the visit");
            visit.setOwner(owner);
        }
        if(visit.getPet() == null){
            System.out.println("Visit had no pet. \n Setting pet to the visit");
            visit.setPet(pet);
            pet.getVisit().add(visit);
        }
        if(visit.getVet() == null){
            System.out.println("Visit had no vets assigned");
        }
        ownerServices.save(owner);
        return "redirect:/owners/{ownerId}";
    }


}
