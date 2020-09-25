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

    @GetMapping("/owners/{ownersId}/pets/new")
    public ModelAndView addPet(@PathVariable Long ownersId){
        Owner owner = ownerServices.findById(ownersId);
        Pet pet = new Pet();
        if(owner == null)
            throw new RuntimeException("There is no owner with the id: "+ownersId);
        pet.setOwner(owner);
        ModelAndView mv = new ModelAndView("pets/createOrUpdatePet");
        mv.addObject(pet);
        return  mv;
    }

    @PostMapping("/owners/{ownersId}/pets/new")
    public String addOrUpdatePet(@ModelAttribute Pet pet, @PathVariable Long ownersId) throws Exception{
        Owner owner = ownerServices.findById(ownersId);
        if(owner == null)
            throw new RuntimeException("There is no owner with the id: "+ownersId);
        owner.getPets().add(pet);
        ownerServices.save(owner);
        return "redirect:/owners/{ownersPd}";
    }

}
