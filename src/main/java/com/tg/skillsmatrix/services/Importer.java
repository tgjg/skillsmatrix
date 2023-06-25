package com.tg.skillsmatrix.services;

import com.tg.skillsmatrix.entity.*;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.repository.CyberFunctionRepository;
import com.tg.skillsmatrix.repository.CyberRoleRepository;
import com.tg.skillsmatrix.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class Importer {

    CoreCyberSkillRepository coreCyberSkillRepository;
    CyberRoleRepository cyberRoleRepository;
    CyberFunctionRepository cyberFunctionRepository;

    PersonRepository personRepository;

    List<CoreCyberSkill> coreCyberSkillList = new ArrayList<>();
    Map<String,CyberRole> cyberRoleMap = new HashMap<>();
    Map<String, CyberFunction> cyberFunctionMap = new HashMap<>();
    Map<String, Set<String>> cyberRoleCyberFunctionMap = new HashMap<>();
    Map<String, CoreCyberSkill> coreCyberSkillMap = new HashMap<>();

    public Importer(CoreCyberSkillRepository coreCyberSkillRepository,
            CyberRoleRepository cyberRoleRepository, CyberFunctionRepository cyberFunctionRepository,
                    PersonRepository personRepository) {
        this.cyberRoleRepository = cyberRoleRepository;
        this.coreCyberSkillRepository = coreCyberSkillRepository;
        this.cyberFunctionRepository = cyberFunctionRepository;
        this.personRepository = personRepository;
    }


    public void import_core_skills() throws IOException {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("/home/tony/work/skillsmatrix/SkillsMatrix/src/main/resources/import/core_skills.csv"));
            String entry ;

            CyberRole cyberRole = null;
            CyberFunction cyberFunction = null;
            CoreCyberSkill coreSkill = null;

            while ( (entry = reader.readLine())!= null) {
                String[] parts = entry.split(",");
                coreSkill = new CoreCyberSkill(parts[0], parts[1]);
                coreCyberSkillMap.put(parts[0], coreSkill);

                if ( !cyberRoleMap.containsKey(parts[1])) {
                    cyberRole = new CyberRole(parts[1]);
                    cyberRoleMap.put(parts[1], cyberRole);
                }
                else {
                    cyberRole = cyberRoleMap.get(parts[1]);
                }

                // primary function
                if ( parts.length > 2) {
                    update_function_map(parts[2], cyberRole);
                    coreSkill = update_core(parts[2], coreSkill);
                    //update_role_and_function_map(parts[1], parts[2]);
                }

                // secondary function
                if ( parts.length > 3 ) {
                    update_function_map(parts[3], cyberRole);
                    coreSkill = update_core(parts[3], coreSkill);
                    //update_role_and_function_map(parts[1], parts[3]);
                }

                if ( parts.length > 4 ) {
                    update_function_map(parts[4], cyberRole);
                    coreSkill = update_core(parts[4], coreSkill);
                    //update_role_and_function_map(parts[1], parts[4]);
                }

                coreCyberSkillList.add(coreSkill);

            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Person person = new Person("Joe", "Smith");
        personRepository.save(person);
        coreCyberSkillRepository.saveAllAndFlush(coreCyberSkillList);

        PersonCyberSkill personCyberSkill = new PersonCyberSkill();

        CoreCyberSkill coreCyberSkill = coreCyberSkillRepository.fetchById(5L);
        personCyberSkill.setCoreCyberSkill(coreCyberSkill);
        personCyberSkill.setPerson(person);


        person.getPersonCyberSkillSet().add(personCyberSkill);
        personRepository.savePerson(person);


        //cyberRoleRepository.saveAll(cyberRoleMap.values());
        //cyberFunctionRepository.saveAll(cyberFunctionMap.values());

        //update_role_and_function_repository();

        //coreCyberSkillRepository.saveAll(coreCyberSkillList);
        //cyberRoleRepository.saveAll(cyberRoleMap.values());
        //cyberFunctionRepository.saveAll(cyberFunctionMap.values());

        return;
    }

    private void update_function_map(String function, CyberRole cyberRole) {
        CyberFunction cyberFunction = null;
        if ( !cyberFunctionMap.containsKey(function)) {
            if (function.isEmpty()) {
                return;
            }
            cyberFunction = new CyberFunction(function);
        }
        else {
            cyberFunction = cyberFunctionMap.get(function);
        }
        cyberFunction.getCyberRoleSet().add(cyberRole);

        cyberFunctionMap.put(function, cyberFunction);
        cyberRole.getCyberFunctionSet().add(cyberFunction);
    }

    private CoreCyberSkill update_core(String function, CoreCyberSkill coreCyberSkill) {
        CyberFunction cyberFunction = cyberFunctionMap.get(function);
        coreCyberSkill.getCyberFunctionSet().add(cyberFunction);

        cyberFunction.getCoreCyberSkillSet().add(coreCyberSkill);

        return coreCyberSkill;

    }


}


