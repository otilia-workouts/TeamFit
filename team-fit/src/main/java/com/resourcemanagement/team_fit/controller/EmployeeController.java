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

    @PostMapping("/person/save")
    public @ResponseBody void saveEmployee(@RequestBody Employee employee) {
        projectService.savePerson(employee);
    }

    @PutMapping("/person/save/{id}")
    public @ResponseBody Person updatePerson (@RequestBody Employee employee, @PathVariable(value = "id") Long  employeeId) {
        return projectService.updatePerson(employee, employeeId);
    }
    @GetMapping("/person/{id}")
    public @ResponseBody Person getEmployeeById(@PathVariable(value = "id") String  employeeId) {
        return projectService.getPersonById(Long.valueOf(employeeId));
    }

    @GetMapping("/all-people")
    public @ResponseBody List<Person> getAllPeople() {
        return projectService.getAllPeople();
    }

    @DeleteMapping("/person/delete/{id}")
    public @ResponseBody void deleteEmployee(@PathVariable(value = "id") String  employeeId) {
        projectService.deletePerson(Long.valueOf(employeeId));
    }
}
