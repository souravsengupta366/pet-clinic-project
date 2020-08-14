package com.sourav.petclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PetType extends BaseEntity {
    private String name;


}
