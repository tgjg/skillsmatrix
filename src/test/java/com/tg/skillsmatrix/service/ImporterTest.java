package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.Type.SkillExperienceEnum;
import com.tg.skillsmatrix.entity.*;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.repository.CyberFunctionRepository;
import com.tg.skillsmatrix.repository.CyberRoleRepository;
import com.tg.skillsmatrix.repository.PersonRepository;
import com.tg.skillsmatrix.services.Importer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ImporterTest {

    static boolean initImporter = false;
    @Autowired
    Importer importer;

    @Autowired
    CoreCyberSkillRepository coreCyberSkillRepository;

    @Autowired
    CyberFunctionRepository cyberFunctionRepository;

    @Autowired
    CyberRoleRepository cyberRoleRepository;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    public void setupTests() throws IOException {
        if ( !initImporter) {
            importer.import_core_skills();
            initImporter = true;
        }
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

    @Test
    void createRandomPerson() throws Exception {
        Person person = new Person("Joe", "Bloggs");
        Person p2 = personRepository.save(person);
        assertTrue(p2.getPersonId().equals(person.getPersonId()));


        CoreCyberSkill coreCyberSkill = coreCyberSkillRepository.fetchById(20L);

        PersonCyberSkill personCyberSkill = new PersonCyberSkill();
        personCyberSkill.setCoreCyberSkill(coreCyberSkill);
        personCyberSkill.setSkillExperienceEnum(SkillExperienceEnum.INFORMED);

        String skillDetail = "Skill detail for " + coreCyberSkill.getCore_skill_name();

        personCyberSkill.setCyberSkillPersonalDetail(skillDetail);
        Set<PersonCyberSkill> personCyberSkillSet = person.getCyberSkillSet();
        personCyberSkillSet.add(personCyberSkill);
        person.setCyberSkillSet(personCyberSkillSet);

        Set<CyberFunction> cyberFunctionSet = person.getCyberFunctionSet();
        cyberFunctionSet.add(cyberFunctionRepository.findById(3L).get());
        cyberFunctionSet.add(cyberFunctionRepository.findById(4L).get());
        person.setCyberFunctionSet(cyberFunctionSet);

        /*
        Set<CyberRole> cyberRoleSet = person.getCyberRoleSet();

        for (PersonCyberSkill pck : personCyberSkillSet) {
            CoreCyberSkill coreSkill = pck.getCoreCyberSkill();
            String cyber_role = coreSkill.getSkillRole();
            cyberRoleSet.add(cyberRoleRepository.fetchByName(cyber_role));
        }

        person.setCyberRoleSet(cyberRoleSet);
*/
        Person p3 = personRepository.save(person);

        assertTrue(p3.getCyberSkillSet().size() > 0);
    }
}
