package com.resourcemanagement.team_fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Web Development Project Team Fit ☻!");
        return  "index";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome(){
        return "home_admin";
    }

    @GetMapping("/menu")
    public String addProj(Model model) {
        model.addAttribute("addProj", "Adăugare proect: ");
        return "menu";
    }

    @GetMapping("/angajatnou")
    public String addPersonForm() {
        return "newemployee";
    }
    @GetMapping("/angajati")
    public String showEmployees(){
        return "allemployees";
    }
    @GetMapping("/proiectnou")
    public String addProjectForm() {
        return "newproject";
    }

    @GetMapping("/proiecte")
    public String showProjects(){
        return "allprojects";
    }

    @GetMapping("/comparareabilitati")
    public String showCompare(){
        return "compareskills";
    }

    @GetMapping("/abilitatenoua")
    public String addSkillForm() {
        return "newskill";
    }

    @GetMapping("/abilitati")
    public String showSkills(){
        return "allskills";
    }
}
