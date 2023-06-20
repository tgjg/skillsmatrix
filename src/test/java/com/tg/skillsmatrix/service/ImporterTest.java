package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.services.Importer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ImporterTest {

    @Autowired
    Importer importer;

    @Autowired
    CoreCyberSkillRepository coreCyberSkillRepository;

    @Test
    void importTest() throws Exception {

        importer.import_core_skills();

        List<CoreCyberSkill> coreCyberSkillList = coreCyberSkillRepository.findAll();

        assertTrue(coreCyberSkillList.size() > 0);

        Set<CyberFunction> cyberFunctionSet = coreCyberSkillList.get(0).getCyberFunctionSet();
        assertTrue(cyberFunctionSet.size() > 0);

        return;

    }
}
