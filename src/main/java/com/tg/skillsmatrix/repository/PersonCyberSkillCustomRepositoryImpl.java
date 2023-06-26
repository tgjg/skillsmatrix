package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberRole;
import com.tg.skillsmatrix.entity.PersonCyberSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonCyberSkillCustomRepositoryImpl implements PersonCyberSkillCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PersonCyberSkill savePersonCyberSkill(PersonCyberSkill personCyberSkill) {
        if ( personCyberSkill.getPerson_skill_id() == null) {
            PersonCyberSkill personCyberSkill1 = (PersonCyberSkill) entityManager.merge(personCyberSkill);
        }
        else {
            entityManager.persist(personCyberSkill);
        }
        return  personCyberSkill;
    }
}
