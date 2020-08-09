package com.sourav.petclinic.controller;

import com.sourav.petclinic.services.VetServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetServices vetServices;

    VetController(VetServices vetServices){
        this.vetServices = vetServices;
    }
    @RequestMapping({"/vets","/vet","vets/index","vet/index","vets/index.html","vet/index.html"})
    public String getList(Model model){
        model.addAttribute("vets",vetServices.findAll());
        return "vets/index";
    }
}
