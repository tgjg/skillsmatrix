package com.tg.skillsmatrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Capability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capability_id")
    private Long capabilityId;

    private String name;
    private String description;


    @OneToMany(mappedBy = "capability", cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    private Set<SkillGeneral> generalSkillSet = new HashSet<>();



}
