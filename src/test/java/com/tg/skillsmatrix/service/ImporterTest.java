package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.entity.*;
import com.tg.skillsmatrix.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;

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

    @Autowired
    PersonCyberSkillRepository personCyberSkillRepository;


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
        Person person = personRepository.fetchById(1L);

        List<CoreCyberSkill> coreCyberSkillList = coreCyberSkillRepository.fetchAll();

        // set the person's function set

        Set<CyberFunction> cyberFunctionSet = person.getCyberFunctionSet();


        Map<String, CyberFunction> functionMap = new HashMap<>();
        for (CyberFunction cf : person.getCyberFunctionSet()) {
            if ( !functionMap.containsKey(cf.getCyber_function_name())) {
                functionMap.put(cf.getCyber_function_name(), cf);
                cyberFunctionSet.add(cf);
            }
        }

        /*
        for (CyberFunction cf : personCyberSkill2.getCoreCyberSkill().getCyberFunctionSet()) {
            if ( !functionMap.containsKey(cf.getCyber_function_name())) {
                functionMap.put(cf.getCyber_function_name(), cf);
                cyberFunctionSet.add(cf);
            }
        }


        person.setCyberFunctionSet(cyberFunctionSet);
*/
        // set the person's role set
        /*
        Set<CyberRole> cyberRoleSet = person.getCyberRoleSet();

        for (PersonCyberSkill pck : personCyberSkillSet) {
            CoreCyberSkill coreSkill = pck.getCoreCyberSkill();
            String cyber_role = coreSkill.getSkillRole();
            cyberRoleSet.add(cyberRoleRepository.fetchByName(cyber_role));
        }

        person.setCyberRoleSet(cyberRoleSet);
        */

        person = personRepository.savePerson(person);
        assertTrue(person.getPersonCyberSkillSet().size() > 0);

    }
}
