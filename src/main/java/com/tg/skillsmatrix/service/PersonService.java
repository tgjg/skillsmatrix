package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.entity.Person;
import com.tg.skillsmatrix.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    Person createOrUpdatePerson(Person person) {
        return personRepository.savePerson(person);
    }

}
