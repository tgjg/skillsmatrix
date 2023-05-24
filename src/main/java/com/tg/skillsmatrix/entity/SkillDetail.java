package com.tg.skillsmatrix.entity;

import com.tg.skillsmatrix.Type.SkillDetailTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SkillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "skill_detail_id")
    private Long skillDetailId;

    private String skillDetailName;
    private String skillDetailDescription;
    private SkillDetailTypeEnum skillDetailTypeEnum = SkillDetailTypeEnum.UNDEFINED;

    @OneToMany(mappedBy = "skillDetail", cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    private Set<SkillsDetailGeneral> skillsDetailGeneralSet = new HashSet<>();


}
