package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/teamfit")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public @ResponseBody List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/project")
    public @ResponseBody Project getProject() {
        return projectService.getProject();
    }

    @PostMapping("/project")
    public @ResponseBody void addProject(@RequestBody Project project) {
        projectService.addProject(project);
    }


}
