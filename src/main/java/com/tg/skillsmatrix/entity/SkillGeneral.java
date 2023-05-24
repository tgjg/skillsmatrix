package com.tg.skillsmatrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tg.skillsmatrix.Type.SkillGeneralEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SkillGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "general_skill_id")
    private Long skillGeneralId;

    private String generalSkillName;
    private String generalSkillDescription;
    private SkillGeneralEnum skillGeneralEnum;


    @OneToMany(mappedBy = "skillGeneral", cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    private Set<SkillsDetailGeneral> skillsDetailGeneralSet = new HashSet<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="capabilityId")
    private Capability capability;


}
