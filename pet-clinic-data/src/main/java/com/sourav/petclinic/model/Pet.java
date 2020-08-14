package com.sourav.petclinic.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pet extends BaseEntity{

    private String name;
    private LocalDate birthDate;
    private PetType type;
    private Owner owner;

}
