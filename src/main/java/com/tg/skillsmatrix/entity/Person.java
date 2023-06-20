package com.tg.skillsmatrix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Long personId;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<CyberRole> cyberRoleSet = new HashSet<>();

}
