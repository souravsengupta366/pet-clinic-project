package com.sourav.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets","/vet","vets/index","vet/index","vets/index.html","vet/index.html"})
    public String getList(){
        return "vets/index";
    }
}
