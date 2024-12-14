package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ViewController {

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
