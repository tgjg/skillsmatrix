package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CoreCyberSkillRepository extends JpaRepository<CoreCyberSkill, Long>, CoreCyberSkillCustomRepository {




}
