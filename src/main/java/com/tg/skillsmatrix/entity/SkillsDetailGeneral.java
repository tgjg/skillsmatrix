package com.tg.skillsmatrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class SkillsDetailGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "skill_detail_general_id", nullable = false)
    private Long skillDetailGeneralId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skillDetailId")
    private SkillDetail skillDetail;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skillGeneralId")
    private SkillGeneral skillGeneral;


}
