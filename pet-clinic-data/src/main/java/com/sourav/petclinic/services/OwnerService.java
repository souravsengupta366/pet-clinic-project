package com.sourav.petclinic.services;

import com.sourav.petclinic.model.Owner;

public interface OwnerService  extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
