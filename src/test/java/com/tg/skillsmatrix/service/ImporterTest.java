package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.entity.CyberRole;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.repository.CyberFunctionRepository;
import com.tg.skillsmatrix.repository.CyberRoleRepository;
import com.tg.skillsmatrix.services.Importer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ImporterTest {

    @Autowired
    Importer importer;

    @Autowired
    CoreCyberSkillRepository coreCyberSkillRepository;

    @Autowired
    CyberFunctionRepository cyberFunctionRepository;

    @Autowired
    CyberRoleRepository cyberRoleRepository;

    @BeforeEach
    void setupTests() throws IOException {
        importer.import_core_skills();
    }

    @Test
    void importTest() throws Exception {

        CoreCyberSkill coreCyberSkill = coreCyberSkillRepository.fetchById(1L);

        assertTrue(coreCyberSkill != null);

        Set<CyberFunction> cyberFunctionSet = coreCyberSkill.getCyberFunctionSet();
        assertTrue(cyberFunctionSet.size() > 0);

        return;

    }

    @Test
    void importCyberFunction() throws Exception {

        CyberFunction cyberFunction = cyberFunctionRepository.fetchById(2L);
        assertTrue(cyberFunction != null);

    }

    @Test
    void importAllCyberFunctions() throws Exception {
        List<CyberFunction> cyberFunctionList = cyberFunctionRepository.fetchAll();
        assertTrue(cyberFunctionList.size() > 1);
    }

    @Test
    void importCyberRoles() throws Exception {
        CyberRole cyberRole = cyberRoleRepository.fetchById(3L);
        assertTrue(cyberRole != null);
    }
}
