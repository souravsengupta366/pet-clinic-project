package com.sourav.petclinic.model;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@EqualsAndHashCode -> is not considering the fields which is being inherited from the super or parent class, this is why @Data is not a good option.

public class Vet extends Person{

    private Set<Specialty> specialties = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(specialties, vet.specialties) && Objects.equals(id,vet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialties, id);
    }
}
