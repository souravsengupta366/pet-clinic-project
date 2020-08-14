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
public class Owner extends Person{

    private String address;
    private String city;
    private String phone;
    private Set<Pet> pets = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(address, owner.address) &&
                Objects.equals(city, owner.city) &&
                Objects.equals(phone, owner.phone) &&
                Objects.equals(pets, owner.pets) && Objects.equals(id,owner.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, city, phone, id);
    }
}
