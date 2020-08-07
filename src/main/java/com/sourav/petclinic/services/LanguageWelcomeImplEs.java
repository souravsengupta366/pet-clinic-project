package com.sourav.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("es")
@Service
public class LanguageWelcomeImplEs implements LanguageWelcome {
    @Override
    public String getMessage() {
        return "Hola monda! ES";
    }
}
