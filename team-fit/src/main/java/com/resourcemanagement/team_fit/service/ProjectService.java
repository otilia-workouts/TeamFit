package com.resourcemanagement.team_fit.service;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import com.resourcemanagement.team_fit.repository.PersonRepository;
import com.resourcemanagement.team_fit.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonRepository personRepository;

    //region CRUD
    public void savePerson(Employee employee){
        personRepository.save(employee);
    }

    public Person updatePerson(Employee employee, Long personId){
        Person personDB= personRepository.findById(personId).orElse(null);
        System.out.println(personId);
        System.out.println(personDB);

        if(personDB != null){
            personDB.setAddress(employee.getAddress());
            personDB.setAge(employee.getAge());
            personDB.setEmail(employee.getEmail());
            personDB.setMarried(employee.isMarried());
            personDB.setFirstName(employee.getFirstName());
            personDB.setLastName(employee.getLastName());

            return personRepository.save(personDB);
        }
        return null;
    }

    public Person getPersonById(Long employeeId){
        return personRepository.findById(employeeId).orElse(null);
    }

    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }


    public void deletePerson(Long employeeId){
        personRepository.deleteById(employeeId);
    }

    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public Project updateProject(Project project, Long projectId) {
        Project projectDB= projectRepository.findById(projectId).orElse(null);

        if(projectDB != null){
            projectDB.setTitle(project.getTitle());
            projectDB.setEmployees((ArrayList<Person>) project.getEmployees());
            projectDB.setRequirements((ArrayList<Skill>) project.getRequirements());
            projectDB.setFinish(project.getFinish());

            return projectRepository.save(projectDB);
        }
        return null;
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public void deleteProject(Project project){
        projectRepository.deleteById(project.getId());
    }

    //endregion
}
