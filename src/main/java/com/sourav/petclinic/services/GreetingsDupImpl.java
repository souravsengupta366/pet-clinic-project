package com.sourav.petclinic.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingsDupImpl  implements  Greetings{
    @Override
    public String getGreetings() {
        return "Hello World Duplicate!";
    }
}
