package com.tg.skillsmatrix.controller;

import com.tg.skillsmatrix.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("pageName", "HomePage");
        return "home";
    }

    @GetMapping("/coreskills")
    public String coreSkillsPage(Model model) {
        model.addAttribute("pageName", "CoreSkillsPage");
        return "coreskills";
    }

}
