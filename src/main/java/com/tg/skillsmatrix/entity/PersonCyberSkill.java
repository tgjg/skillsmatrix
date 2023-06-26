package com.tg.skillsmatrix.entity;

import com.tg.skillsmatrix.Type.SkillExperienceEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person_cyber_skill")
@Getter
@Setter
public class PersonCyberSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long person_skill_id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "core_skill_id")
    private CoreCyberSkill coreCyberSkill;

    private String cyberSkillPersonalDetail;
    private SkillExperienceEnum skillExperienceEnum = SkillExperienceEnum.NONE;


}
