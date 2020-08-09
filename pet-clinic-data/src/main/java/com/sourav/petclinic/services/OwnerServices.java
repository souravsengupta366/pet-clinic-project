package com.sourav.petclinic.services;

import com.sourav.petclinic.model.Owner;

public interface OwnerServices extends CrudService<Owner,Long>{
//    public final boolean flagTest = false;
    Owner findByLastName(String lastName);

}
