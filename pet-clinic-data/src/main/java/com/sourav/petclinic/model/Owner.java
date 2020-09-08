package com.sourav.petclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Owners")
public class Owner extends Person{


    private String address;
    private String city;
    private String phone;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String phone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;

        if(pets != null) {
            this.pets = pets;
        }
    }

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
