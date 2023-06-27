package com.tg.skillsmatrix.controller;

import com.tg.skillsmatrix.dao.CoreCyberSkillsDao;
import com.tg.skillsmatrix.entity.CoreCyberSkill;
import com.tg.skillsmatrix.repository.CoreCyberSkillRepository;
import com.tg.skillsmatrix.service.CoreSkillsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillsRestController {

    CoreSkillsService coreSkillsService;

    public SkillsRestController(CoreSkillsService coreSkillsService) {
        this.coreSkillsService = coreSkillsService;
    }

    @GetMapping("/core_skills_list")
    public List<CoreCyberSkillsDao> getCoreSkillsList() {
        List<CoreCyberSkillsDao> coreCyberSkillsDaoList = coreSkillsService.getCoreCyberSkillsDaoList();
        return coreCyberSkillsDaoList;
    }
}
