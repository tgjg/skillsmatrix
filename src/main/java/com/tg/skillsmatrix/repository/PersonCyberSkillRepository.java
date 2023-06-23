package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.PersonCyberSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCyberSkillRepository extends JpaRepository<PersonCyberSkill, Long>, PersonCyberSkillCustomRepository {
}
