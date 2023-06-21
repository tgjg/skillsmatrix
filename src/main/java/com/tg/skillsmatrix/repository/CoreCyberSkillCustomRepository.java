package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CoreCyberSkill;

public interface CoreCyberSkillCustomRepository {

    CoreCyberSkill fetchById(Long id);
}
