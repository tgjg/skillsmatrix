package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.entity.CyberRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CyberRoleCustomRepositoryImpl implements CyberRoleCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public CyberRole fetchById(Long cyber_role_id) {
        return (CyberRole) entityManager.createQuery("select cr from CyberRole cr left join fetch cr.cyberFunctionSet left join fetch cr.personSet WHERE cr.cyberRoleId = :cyber_role_id")
                .setParameter("cyber_role_id", cyber_role_id)
                .getSingleResult();
    }

    @Override
    public CyberRole fetchByName(String cyber_role_name) {
        return (CyberRole) entityManager.createQuery("select cr from CyberRole cr WHERE cr.cyber_role_name = :cyber_role_name")
                .setParameter("cyber_role_name", cyber_role_name)
                .getSingleResult();
    }
}
