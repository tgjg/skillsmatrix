package com.tg.skillsmatrix.repository;

import com.tg.skillsmatrix.entity.CyberFunction;

import java.util.List;

public interface CyberFunctionCustomRepository {

    CyberFunction fetchById(Long id);
    List<CyberFunction> fetchAll();
}
