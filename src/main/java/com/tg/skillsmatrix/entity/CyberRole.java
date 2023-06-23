package com.tg.skillsmatrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tg.skillsmatrix.Type.SkillDetailTypeEnum;
import com.tg.skillsmatrix.Type.SkillExperienceEnum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class CyberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cyber_role_id")
    private Long cyberRoleId;
    private String cyber_role_name;

    public CyberRole() {

    }

    public CyberRole(String cyberRoleName) {
        this.cyber_role_name = cyberRoleName;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="role_person",
            joinColumns = @JoinColumn(name = "cyber_role_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> personSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="role_function",
            joinColumns = @JoinColumn(name = "cyber_role_id"),
            inverseJoinColumns = @JoinColumn(name = "cyber_function_id")
    )
    private Set<CyberFunction> cyberFunctionSet = new HashSet<>();

}
