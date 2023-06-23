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
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<CyberRole> cyberRoleSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<CyberFunction> cyberFunctionSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PersonCyberSkill> cyberSkillSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<NonCoreCyberSkill> nonCoreCyberSkillSet = new HashSet<>();


    public Person() {

    }

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }
}
