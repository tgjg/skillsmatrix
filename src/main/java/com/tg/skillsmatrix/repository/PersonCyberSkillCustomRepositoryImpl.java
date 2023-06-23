package com.tg.skillsmatrix.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonCyberSkillCustomRepositoryImpl implements PersonCyberSkillCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
