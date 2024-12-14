package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.enums.Level;
import com.resourcemanagement.team_fit.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/teamfit")
public class SkillController {

    private final ProjectService projectService;

    public SkillController(ProjectService projectService){
        this.projectService=projectService;
    }

    @PostMapping("/skill/save")
    public @ResponseBody void saveSkill(@RequestBody Skill skill) {
        projectService.saveSkill(skill);
    }

    @GetMapping("/all-skills")
    public @ResponseBody List<Skill> getAllSkills() {
        return projectService.getAllSkills();
    }

    @GetMapping("/levels")
    public @ResponseBody List<Level> getAllLevels() {
        return Arrays.asList(Level.values());
    }

}
