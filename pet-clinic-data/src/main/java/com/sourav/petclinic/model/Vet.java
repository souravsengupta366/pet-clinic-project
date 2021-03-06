package com.sourav.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode -> is not considering the fields which is being inherited from the super or parent class, this is why @Data is not a good option.

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany (fetch = FetchType.EAGER)//by default its lazy
    @JoinTable(name = "vet_specialty_rel",
    joinColumns = @JoinColumn(name = "vet_fk"),
    inverseJoinColumns = @JoinColumn(name = "specialty_fk"))
    private Set<Specialty> specialties = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vet")
    private Set<Visit> visits = new HashSet<>();


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

    @Override
    public String toString() {
        return getFirstName()+" "+getLastName();
    }
}
