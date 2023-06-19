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
public class CoreCyberSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "skill_detail_id")
    private Long skillDetailId;

    private String skillDetailName;
    private String skillRole;

    public CoreCyberSkill() {

    }
    public CoreCyberSkill(String coreCyberSkill, String cyberRole) {
        this.skillDetailName = coreCyberSkill;
        this.skillRole = cyberRole;
    }

}
