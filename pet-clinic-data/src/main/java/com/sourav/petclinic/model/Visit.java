package com.sourav.petclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Visit extends BaseEntity{

    private LocalDate date;
    Pet pet;
    String description;
}
