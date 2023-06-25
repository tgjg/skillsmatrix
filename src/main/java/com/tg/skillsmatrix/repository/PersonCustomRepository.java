package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.Person;
import com.tg.skillsmatrix.entity.PersonCyberSkill;

public interface PersonCustomRepository {

    Person fetchById(Long id);

    Person savePerson(Person person);

}
