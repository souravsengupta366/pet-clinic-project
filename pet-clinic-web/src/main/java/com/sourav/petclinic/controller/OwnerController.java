package com.sourav.petclinic.controller;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.services.OwnerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class OwnerController {
    private final OwnerServices ownerServices;

    OwnerController(OwnerServices ownerServices){
        this.ownerServices = ownerServices;
    }

    @RequestMapping({"/owners","/owner","owners/index","owner/index","owners/index.html","owner/index.html"})
    public String ownerIndex(Model model){


        Set<Owner> setOfOwners = ownerServices.findAll();
        System.out.println("Size of owner's list = "+setOfOwners.size());
        model.addAttribute("owners",ownerServices.findAll());
        return "owners/index";
    }
}
