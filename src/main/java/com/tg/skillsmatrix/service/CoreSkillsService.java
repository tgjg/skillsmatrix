package com.tg.skillsmatrix.service;

import com.tg.skillsmatrix.dao.CoreCyberSkillsDao;
import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.entity.CyberFunction;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoreSkillsService {

    CoreCyberSkillRepository coreCyberSkillRepository;
    public CoreSkillsService(CoreCyberSkillRepository coreCyberSkillRepository) {
        this.coreCyberSkillRepository = coreCyberSkillRepository;
    }

    public List<CoreCyberSkillsDao> getCoreCyberSkillsDaoList() {
        List<CoreCyberSkill> coreCyberSkillList = coreCyberSkillRepository.fetchAllSkillsAndFunctions();
        List<CoreCyberSkillsDao> coreCyberSkillsDaoList = new ArrayList<>();

        Long roleId = 1L;
        for (CoreCyberSkill coreCyberSkill : coreCyberSkillList) {
            for (CyberFunction cyberFunction : coreCyberSkill.getCyberFunctionSet()) {
                CoreCyberSkillsDao coreCyberSkillsDao = new CoreCyberSkillsDao();
                coreCyberSkillsDao.setId(roleId++);
                coreCyberSkillsDao.setCore_skill_name(coreCyberSkill.getCore_skill_name());
                coreCyberSkillsDao.setRole(coreCyberSkill.getSkillRole());
                coreCyberSkillsDao.setFunction(cyberFunction.getCyber_function_name());

                coreCyberSkillsDaoList.add(coreCyberSkillsDao);

            }
        }
        return coreCyberSkillsDaoList;
    };
}
