package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import com.resourcemanagement.team_fit.service.ProjectService;
import com.resourcemanagement.team_fit.service.SeedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/teamfit")
public class ProjectController {

    private final ProjectService projectService;
    private final SeedService seedService;

    public ProjectController(ProjectService projectService, SeedService seedService) {
        this.projectService = projectService;
        this.seedService = seedService;
    }

    @GetMapping("/projects")
    public @ResponseBody List<Project> getProjects() {
        return seedService.getProjects();
    }

    @GetMapping("/project")
    public @ResponseBody Project getProject() {
        return seedService.getProject();
    }

    @PostMapping("/project")
    public @ResponseBody void addProject(@RequestBody Project project) {
        seedService.addProject(project);
    }

    @PostMapping("/project/save")
    public @ResponseBody void saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @PutMapping("/project/save/{id}")
    public @ResponseBody Project updateProject (@RequestBody Project project, @PathVariable(value = "id") Long  projectId) {
        return projectService.updateProject(project, projectId);
    }

    @GetMapping("/project/{id}")
    public @ResponseBody Project getProjectById(@PathVariable(value = "id") String  projectId) {
        return projectService.getProjectById(Long.valueOf(projectId));
    }

    @GetMapping("/all-projects")
    public @ResponseBody List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/project/delete")
    public @ResponseBody void deleteProject(@RequestBody Project project) {
        projectService.deleteProject(project);
    }
}
