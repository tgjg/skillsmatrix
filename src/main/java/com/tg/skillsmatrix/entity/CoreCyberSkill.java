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
    @Column(name = "core_skill_id")
    private Long core_skill_id;

    private String core_skill_name;
    private String skillRole;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="core_skill_function",
            joinColumns = @JoinColumn(name = "core_skill_id"),
            inverseJoinColumns = @JoinColumn(name = "cyber_function_id")
    )
    private Set<CyberFunction> cyberFunctionSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PersonCyberSkill> personCyberSkillSet = new HashSet<>();


    public CoreCyberSkill() {

    }
    public CoreCyberSkill(String coreCyberSkill, String cyberRole) {
        this.core_skill_name = coreCyberSkill;
        this.skillRole = cyberRole;
    }

}
