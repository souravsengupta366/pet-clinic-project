package com.sourav.petclinic.parser;

import com.sourav.petclinic.exceptionClasses.NotFoundException;
import com.sourav.petclinic.model.Vet;
import com.sourav.petclinic.services.VetServices;
import org.springframework.format.Parser;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class VetParser implements Parser<Vet> {

    private final VetServices vetServices;

    public VetParser(VetServices vetServices) {
        this.vetServices = vetServices;
    }

    @Override
    public Vet parse(String s, Locale locale) throws ParseException {
        String[] name = s.split("\\s+");
        Vet[] vets = new Vet[1];
        vetServices.findAll().forEach(vet -> {
            if(vet.getFirstName().equals(name[0]) && vet.getLastName().equals(name[1])){
                vets[0] = vet;
            }
        });
        if(vets[0] == null){
            throw  new NotFoundException("There is no vet with the given name");
        }
        return vets[0];
    }
}
