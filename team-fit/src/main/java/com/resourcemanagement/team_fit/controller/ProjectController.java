package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teamfit")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
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

    @GetMapping("/project/{id}/compatibitities")
    public @ResponseBody Map<List<String>,Map<String,List<Boolean>>> getCompatibilities(@PathVariable(value = "id") String  projectId){
       return projectService.getEmployeeCompatibility(Long.valueOf(projectId));
    }
    @DeleteMapping("/project/delete")
    public @ResponseBody void deleteProject(@RequestBody Project project) {
        projectService.deleteProject(project);
    }
}
