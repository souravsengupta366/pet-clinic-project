package com.sourav.petclinic.parser;

import com.sourav.petclinic.model.PetType;
import com.sourav.petclinic.services.PetTypeServices;
import org.springframework.format.Parser;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class TypeParser implements Parser<PetType> {
    private final PetTypeServices petTypeServices;

    public TypeParser(PetTypeServices petTypeServices) {
        this.petTypeServices = petTypeServices;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        PetType[] petType = new PetType[1];
        petTypeServices.findAll().forEach(type -> {
            if(type.getName().equalsIgnoreCase(s))
                petType[0] =  type;
        });
        if(petType[0]!= null)
            return petType[0];
        throw new RuntimeException("There is no such pet types"+ s);
    }
}
