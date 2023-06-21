package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyberFunctionRepository extends JpaRepository<CyberFunction, Long>, CyberFunctionCustomRepository {
}
