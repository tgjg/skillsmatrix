package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberRole;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CyberRoleRepository extends JpaRepository<CyberRole, Long>, CyberRoleCustomRepository {



}
