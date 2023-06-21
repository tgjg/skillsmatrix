package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberRole;

public interface CyberRoleCustomRepository {

    CyberRole fetchById(Long id);
}
