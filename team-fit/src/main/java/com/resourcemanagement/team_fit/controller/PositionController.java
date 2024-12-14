package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.basic.Position;
import com.resourcemanagement.team_fit.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teamfit")
public class PositionController {
    private final ProjectService projectService;

    public PositionController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/position/save")
    public @ResponseBody void savePosition(@RequestBody Position position) {
        projectService.savePosition(position);
    }

    @GetMapping("/position/{id}")
    public @ResponseBody Position getPositionById(@PathVariable(value = "id") String  positionId) {
        return projectService.getPositionById(Long.valueOf(positionId));
    }

    @GetMapping("/all-positions")
    public @ResponseBody List<Position> getAllPositions() {
        return projectService.getAllPositions();
    }

    @PutMapping("/position/save/{id}")
    public @ResponseBody Position updatePosition (@RequestBody Position position, @PathVariable(value = "id") Long  positionId) {
        return projectService.updatePosition(position, positionId);
    }

    @DeleteMapping("/position/delete/{id}")
    public @ResponseBody void deletePosition(@PathVariable(value = "id") String  positionId) {
        projectService.deletePosition(Long.valueOf(positionId));
    }
}