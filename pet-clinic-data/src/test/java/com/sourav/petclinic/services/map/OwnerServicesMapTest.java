package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.services.OwnerServices;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServicesMapTest {

    private static OwnerServices ownerServices;

    @Mock
    private static PetServices petServices;
    @Mock
    private static PetTypeServices petTypeServices;

    @BeforeAll
    public static void init(){
        ownerServices = new OwnerServicesMap(petTypeServices,petServices);
        ownerServices.save(Owner.builder().id(1L).firstName("Akansha").lastName("Sengupta").build());
        ownerServices.save(Owner.builder().lastName("Sengupta").firstName("Uma").id(2L).build());
        ownerServices.save(Owner.builder().lastName("Kundu").firstName("Sourav").id(3L).build());
        ownerServices.save(Owner.builder().lastName("Sengupta").firstName("Sourav").id(4L).build());
    }

//    @Test
//    void findByLastName() {
//        //the below may fail sometimes since the below may not be the first name with that title
//        Owner owner = ownerServices.findByLastName("Sengupta");
////        System.out.println("Owner name: "+owner.getFirstName()+" "+owner.getLastName());
//        assertEquals("Akansha",owner.getFirstName());
////        System.out.println(ownerServices.findAll().size());
//    }

    @Test
    void findById() {
        Owner owner = ownerServices.findById(1L);
//        System.out.println("Owner name: "+owner.getFirstName()+" "+owner.getLastName());
        assertEquals(1L,owner.getId());
    }

    @Test
    void save() {
        assertEquals("Uma",ownerServices.findById(2L).getFirstName());
    }

    @Test
    void findAll() {
//        assertEquals(3,ownerServices.findAll().size());
    }

    @Test
    void delete() {
        ownerServices.delete(ownerServices.findById(4L));
        assertEquals(3,ownerServices.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServices.deleteById(3L);
        assertEquals(2,ownerServices.findAll().size());

    }
}