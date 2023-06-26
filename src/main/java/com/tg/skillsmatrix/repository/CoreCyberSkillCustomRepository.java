package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CoreCyberSkill;

import java.util.List;

public interface CoreCyberSkillCustomRepository {

    CoreCyberSkill fetchById(Long id);
    List<CoreCyberSkill> fetchAll();
}
