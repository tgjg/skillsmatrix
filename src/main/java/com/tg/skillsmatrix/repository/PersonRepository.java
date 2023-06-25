package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long>, PersonCustomRepository {
}
