package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberRole;
import com.tg.skillsmatrix.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonCustomRepositoryImpl implements PersonCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person fetchById(Long id) {
        return (Person) entityManager.createQuery("select p from Person p WHERE p.personId = :person_id")
                .setParameter("person_id", id)
                .getSingleResult();
    }
}
