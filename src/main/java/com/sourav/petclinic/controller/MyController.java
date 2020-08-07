package com.sourav.petclinic.controller;

import com.sourav.petclinic.services.Greetings;
import com.sourav.petclinic.services.LanguageWelcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final Greetings greetings;
    private final LanguageWelcome langWel;

    @Autowired
    MyController(Greetings greetings, LanguageWelcome langWel){
        this.greetings = greetings;
        this.langWel = langWel;
    }

    public String sayHello(){
        System.out.println(greetings.getGreetings());
        return "Hi Folks";
    }

    public String i18Hello(){
        System.out.println(langWel.getMessage());
        return "Hi Folks";
    }
}
