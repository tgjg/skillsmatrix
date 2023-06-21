package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.entity.CyberFunction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CyberFunctionCustomRepositoryImpl implements CyberFunctionCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public CyberFunction fetchById(Long cyber_function_id) {
        return (CyberFunction) entityManager.createQuery("select cf from CyberFunction cf left join fetch cf.coreCyberSkillSet left join fetch cf.cyberRoleSet WHERE cf.cyber_function_id = :cyber_function_id")
                .setParameter("cyber_function_id", cyber_function_id)
                .getSingleResult();
    }

    @Override
    public List<CyberFunction> fetchAll() {
        return (List<CyberFunction>) entityManager.createQuery("select cf from CyberFunction cf left join fetch cf.coreCyberSkillSet left join fetch cf.cyberRoleSet")
                .getResultList();
    }


}
