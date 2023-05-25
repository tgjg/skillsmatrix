package com.tg.skillsmatrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tg.skillsmatrix.Type.SkillDetailTypeEnum;
import com.tg.skillsmatrix.Type.SkillExperienceEnum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_skill_id")
    private Long personSkillId;

    private SkillDetailTypeEnum skillDetailTypeEnum = SkillDetailTypeEnum.UNDEFINED;
    private SkillExperienceEnum skillExperienceEnum = SkillExperienceEnum.NONE;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skillDetailId")
    private SkillDetail skillDetail;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="personId")
    private Person person;


}
