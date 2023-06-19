package com.tg.skillsmatrix.services;

import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.entity.CyberRole;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.repository.CyberFunctionRepository;
import com.tg.skillsmatrix.repository.CyberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class Importer {

    CoreCyberSkillRepository coreCyberSkillRepository;
    CyberRoleRepository cyberRoleRepository;
    CyberFunctionRepository cyberFunctionRepository;

    List<CoreCyberSkill> coreCyberSkillList = new ArrayList<>();
    Map<String,CyberRole> cyberRoleMap = new HashMap<>();

    Map<String, CyberFunction> cyberFunctionMap = new HashMap<>();

    Map<String, Set<String>> cyberRoleCyberFunctionMap = new HashMap<>();


    public Importer(CoreCyberSkillRepository coreCyberSkillRepository,
            CyberRoleRepository cyberRoleRepository, CyberFunctionRepository cyberFunctionRepository) {
        this.cyberRoleRepository = cyberRoleRepository;
        this.coreCyberSkillRepository = coreCyberSkillRepository;
        this.cyberFunctionRepository = cyberFunctionRepository;
    }


    public void import_core_skills() throws IOException {

        BufferedReader reader;



        try {
            reader = new BufferedReader(new FileReader("/home/tony/work/skillsmatrix/SkillsMatrix/src/main/resources/import/core_skills.csv"));
            String entry ;

            while ( (entry = reader.readLine())!= null) {
                String[] parts = entry.split(",");
                CoreCyberSkill coreSkill = new CoreCyberSkill(parts[0], parts[1]);

                if ( !cyberRoleMap.containsKey(parts[1])) {
                    CyberRole cyberRole = new CyberRole(parts[1]);
                    cyberRoleMap.put(parts[1], cyberRole);
                }

                if ( !cyberFunctionMap.containsKey(parts[2])) {
                    CyberFunction cyberFunction = new CyberFunction(parts[2]);
                    cyberFunctionMap.put(parts[2], cyberFunction);
                    update_role_and_function_map(parts[1], parts[2]);
                }

                if ( parts.length == 4 ) {
                    if ( !cyberFunctionMap.containsKey(parts[3])) {
                        CyberFunction cyberFunction = new CyberFunction(parts[3]);
                        cyberFunctionMap.put(parts[3], cyberFunction);
                        update_role_and_function_map(parts[1], parts[3]);
                    }
                }

                if ( parts.length == 5 ) {
                    if ( !cyberFunctionMap.containsKey(parts[4])) {
                        CyberFunction cyberFunction = new CyberFunction(parts[4]);
                        cyberFunctionMap.put(parts[4], cyberFunction);
                        update_role_and_function_map(parts[1], parts[4]);
                    }
                }

                coreCyberSkillList.add(coreSkill);


            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        update_role_and_function_repository();

        coreCyberSkillRepository.saveAll(coreCyberSkillList);
        cyberRoleRepository.saveAll(cyberRoleMap.values());
        cyberFunctionRepository.saveAll(cyberFunctionMap.values());



    }

    private void update_role_and_function_map(String role, String function) {
        Set<String> functionSet = this.cyberRoleCyberFunctionMap.get(role);
        if ( functionSet == null) {
            functionSet = new HashSet<>();
        }
        if (!functionSet.contains(function)) {
            functionSet.add(function);
            cyberRoleCyberFunctionMap.put(role, functionSet);
        }

    }

    private void update_role_and_function_repository() {

        Iterator<Map.Entry<String, Set<String>>> it = cyberRoleCyberFunctionMap.entrySet().iterator();
        while (it.hasNext() ) {
            Map.Entry<String, Set<String>> entry = it.next();
            CyberRole cyberRole = cyberRoleMap.get(entry.getKey());
            Set<CyberFunction> fnSet = new HashSet<>();
            for ( String function : entry.getValue()) {
                fnSet.add(cyberFunctionMap.get(function));
            }
            cyberRole.setCyberFunctionSet(fnSet);
            cyberRoleMap.put(entry.getKey(), cyberRole);
        }
    }
}


