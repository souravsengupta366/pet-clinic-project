package com.sourav.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
    @RequestMapping({"/pets","/pet","pets/index","pet/index","pets/index.html","pet/index.html"})
    public String index(){
        return "pets/index";
    }
}
