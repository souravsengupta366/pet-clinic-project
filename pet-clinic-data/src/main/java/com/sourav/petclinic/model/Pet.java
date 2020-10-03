package com.sourav.petclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
public class Pet extends BaseEntity{

    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visit =  new HashSet<>();

    @Builder
    public Pet(Long id, String name, PetType type, Owner owner, LocalDate birthDate, Set<Visit> visit) {
        super(id);
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visit == null || visit.size() > 0 ) {
            this.visit = this.visit;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }


    @Override
    public String toString() {
        if(owner !=  null) {
                return "Pet{" +
                    "name='" + name + '\'' +
                    ", birthDate=" + birthDate +
                    ", type=" + type +
                    ", owner=" + owner.getFirstName() +
                    " " + owner.getLastName() +
                    ", visit=" + visit +
                    '}';
        }
        return "Pet{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", type=" + type +
                ", owner=" + null +
                ", visit=" + visit +
                '}';

    }
}
