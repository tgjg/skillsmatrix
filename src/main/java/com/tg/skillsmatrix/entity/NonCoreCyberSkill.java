package com.tg.skillsmatrix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class NonCoreCyberSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "non_core_skill_id")
    private Long non_core_skill_id;

    private String non_core_skill_name;
    private String skillRole;
    private String cyberFunction;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    public NonCoreCyberSkill() {

    }
    public NonCoreCyberSkill(String non_coreCyberSkill, String cyberRole, String cyberFunction) {
        this.non_core_skill_name = non_coreCyberSkill;
        this.skillRole = cyberRole;
        this.cyberFunction = cyberFunction;
    }

}
