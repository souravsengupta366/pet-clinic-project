package com.sourav.petclinic.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Visit extends BaseEntity{

    private LocalDate date;
    Pet pet;
    String description;
}
