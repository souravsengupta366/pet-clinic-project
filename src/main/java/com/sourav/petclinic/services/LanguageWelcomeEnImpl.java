package com.sourav.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"en","default"})
@Service
public class LanguageWelcomeEnImpl implements LanguageWelcome {
    @Override
    public String getMessage() {
        return "Welocme in English";
    }
}
