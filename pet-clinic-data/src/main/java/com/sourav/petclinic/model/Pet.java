package com.sourav.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Pet extends BaseEntity{

    private String name;
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Set<Visit> visit;

}
