package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.entity.CyberRole;
import com.tg.skillsmatrix.entity.Person;
import com.tg.skillsmatrix.entity.PersonCyberSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PersonCustomRepositoryImpl implements PersonCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person fetchById(Long id) {
        return (Person) entityManager.createQuery("select p from Person p left join fetch p.personCyberSkillSet sk left join fetch sk.coreCyberSkill ck left join fetch ck.cyberFunctionSet WHERE p.person_id = :person_id")
                .setParameter("person_id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Person savePerson(Person person) {
        if ( person.getPerson_id() != null) {
            person = (Person) entityManager.merge(person);
            for ( PersonCyberSkill personCyberSkill : person.getPersonCyberSkillSet()) {
                entityManager.merge(personCyberSkill);
            }

        }
        else {
            entityManager.persist(person);
        }
        return person;
    }
}
