package com.sourav.petclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Specialty extends BaseEntity{
    private String description;
}
