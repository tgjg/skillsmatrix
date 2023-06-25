package com.tg.skillsmatrix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Long person_id;
    private String firstName;
    private String lastName;

    private String primaryRole;

    @Transient
    private Set<CyberRole> cyberRoleSet = new HashSet<>();

    @Transient
    private Set<CyberFunction> cyberFunctionSet = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonCyberSkill> personCyberSkillSet = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    private Set<NonCoreCyberSkill> nonCoreCyberSkillSet = new HashSet<>();

    public Person() {

    }

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }

}
