package com.tg.skillsmatrix.entity;

import com.tg.skillsmatrix.Type.SkillExperienceEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonCyberSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long person_skill_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private CoreCyberSkill coreCyberSkill;

    private String cyberSkillPersonalDetail;
    private SkillExperienceEnum skillExperienceEnum = SkillExperienceEnum.NONE;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

}
