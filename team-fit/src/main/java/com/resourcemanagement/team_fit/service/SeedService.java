package com.resourcemanagement.team_fit.service;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SeedService {
    Person employee1 = new Employee("Ion", "Elena", "ielena@gmail.com", "Brasov", 23, false);
    Person employee2 = new Employee("Ursu", "Anca", "uanca@gmail.com", "Brasov", 19, false);
    Person employee3 = new Employee("Vulpe", "Maria", "vmaria@gmail.com", "Bucuresti", 30, true);
    Person employee4 = new Employee("Cantemir", "Ion", "cion@gmail.com", "Bucuresti", 29, true);
    ArrayList<Person> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4));
    String title = "Java";
    ArrayList<Skill> skills = new ArrayList<>();
    Date start = new Date();
    Date finish = new Date();
    Project project1 = new Project(title, skills, employees, start, finish);

    List<Project> projects = new ArrayList<>(Arrays.asList(project1));


    public List<Project> getProjects() {
        return projects;
    }

    public  Project getProject() {
        return project1;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public Person getEmployeesById(String employeeId) {
        return employees.stream().filter(e -> e.getIdentifier().equals(employeeId) ).findFirst().orElse(new Employee("No person", employeeId,"no emal", "No town",0,false));

    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
