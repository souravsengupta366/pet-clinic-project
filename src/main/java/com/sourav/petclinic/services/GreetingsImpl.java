package com.sourav.petclinic.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class GreetingsImpl implements Greetings{
    @Override
    public String getGreetings(){
        return "Hello World!";
    }
}
