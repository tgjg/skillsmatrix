package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.Person;

public interface PersonCustomRepository {

    Person fetchById(Long id);
}
