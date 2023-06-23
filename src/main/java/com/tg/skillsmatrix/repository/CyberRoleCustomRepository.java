package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberRole;

public interface CyberRoleCustomRepository {

    CyberRole fetchById(Long id);
    CyberRole fetchByName(String cyber_role_name);
}
