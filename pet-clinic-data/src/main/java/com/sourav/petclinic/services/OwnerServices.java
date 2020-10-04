package com.sourav.petclinic.services;

import com.sourav.petclinic.model.Owner;

import java.util.Set;

public interface OwnerServices extends CrudService<Owner,Long>{
//    public final boolean flagTest = false;
    Set<Owner> findByLastName(String lastName);
//    Owner findByName(String firstName, String lastName);
    Set<Owner> findByFirstName(String firstName);

}
