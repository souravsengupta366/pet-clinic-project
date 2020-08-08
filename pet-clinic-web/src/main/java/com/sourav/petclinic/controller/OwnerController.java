package com.sourav.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @RequestMapping({"/owners","/owner","owners/index","owner/index","owners/index.html","owner/index.html"})
    public String index(){
        return "owners/index";
    }
}
