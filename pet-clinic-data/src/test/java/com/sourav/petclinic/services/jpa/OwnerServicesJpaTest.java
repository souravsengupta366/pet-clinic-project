package com.sourav.petclinic.services.jpa;

import com.sourav.petclinic.model.Owner;
import com.sourav.petclinic.repositories.OwnerRepository;
import com.sourav.petclinic.services.PetServices;
import com.sourav.petclinic.services.PetTypeServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerServicesJpaTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetServices petServices;
    @Mock
    PetTypeServices petTypeServices;
    @InjectMocks
    OwnerServicesJpa ownerServicesJpa;

    private static Optional<Owner> owner;
    private static Owner owner2;

    @BeforeAll
    static void init(){
        owner.get().builder().id(1L).firstName("Akansha").lastName("Sengupta").build();
        owner2.builder().id(1L).firstName("Sourav").lastName("Sengupta").build();
    }



    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        ownerRepository.save(owner.get());
        assertEquals("Sengupta",ownerRepository.findByLastName("Sengupta").get().getLastName());
        System.out.println(ownerServicesJpa.findAll().size());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}