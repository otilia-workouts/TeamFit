package com.resourcemanagement.team_fit.controller;

import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import com.resourcemanagement.team_fit.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teamfit")
public class EmployeeController {

    private final ProjectService projectService;

    public EmployeeController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project/persons")
    public @ResponseBody List<Person> getEmployees(){
        return projectService.getEmployees();
    }

    @GetMapping("/project/person/{id}")
    public @ResponseBody Person getEmployee(@PathVariable(value = "id") String  employeeId) {
        return projectService.getEmployeesById(employeeId);
    }

    @PostMapping("/project/person")
    public @ResponseBody void addEmployee(@RequestBody Employee employee) {
        projectService.addEmployee(employee);
    }

}
