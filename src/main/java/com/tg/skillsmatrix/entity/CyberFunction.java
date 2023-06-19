package com.tg.skillsmatrix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class CyberFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cyber_function_id", nullable = false)
    private Long cyber_function_id;

    private String cyber_function_name;

    public CyberFunction() {

    }

    public CyberFunction(String cyber_function_name) {
        this.cyber_function_name = cyber_function_name;
    }

    @ManyToMany
    private Set<CyberRole> cyberRoleSet = new HashSet<>();
}
