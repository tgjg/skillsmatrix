package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CoreCyberSkillCustomRepositoryImpl implements CoreCyberSkillCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CoreCyberSkill fetchById(Long core_skill_id) {
        return (CoreCyberSkill) entityManager.createQuery("select ccs from CoreCyberSkill ccs left join fetch ccs.cyberFunctionSet cfs left join fetch cfs.cyberRoleSet WHERE ccs.core_skill_id = :core_skill_id")
                .setParameter("core_skill_id", core_skill_id)
                .getSingleResult();
    }

    @Override
    public List<CoreCyberSkill> fetchAll() {
        return (List<CoreCyberSkill>) entityManager.createQuery("select ccs from CoreCyberSkill ccs left join fetch ccs.personCyberSkillSet")
                .getResultList();
    }

    @Override
    public List<CoreCyberSkill> fetchAllSkillsAndFunctions() {
        return (List<CoreCyberSkill>) entityManager.createQuery("select ccs from CoreCyberSkill ccs left join fetch ccs.cyberFunctionSet")
                .getResultList();
    }

}
