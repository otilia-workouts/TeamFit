package com.resourcemanagement.team_fit.service;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;
import com.resourcemanagement.team_fit.model.basic.Position;
import com.resourcemanagement.team_fit.repository.PersonRepository;
import com.resourcemanagement.team_fit.repository.PositionRepository;
import com.resourcemanagement.team_fit.repository.ProjectRepository;
import com.resourcemanagement.team_fit.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private PositionRepository positionRepository;

    //region CRUD

    //employee
    public void savePerson(Employee employee) {
        personRepository.save(employee);
    }

    public Person updatePerson(Employee employee, Long personId) {
        Person personDB = personRepository.findById(personId).orElse(null);
        System.out.println(personId);
        System.out.println(personDB);

        if (personDB != null) {

            if (employee.getAddress() != null)
                personDB.setAddress(employee.getAddress());
            if (employee.getAge() != null)
                personDB.setAge(employee.getAge());
            if (employee.getEmail() != null)
                personDB.setEmail(employee.getEmail());
            personDB.setMarried(employee.isMarried());
            if (employee.getFirstName() != null)
                personDB.setFirstName(employee.getFirstName());
            if (employee.getLastName() != null)
                personDB.setLastName(employee.getLastName());

            System.out.println(employee.getSkills() != null && personDB instanceof Employee);

            if (employee.getSkills() != null && personDB instanceof Employee){
                Iterable<Skill> skills = skillRepository.findAllById(employee.getSkills().stream().map(Skill::getId).collect(Collectors.toList()));

                List<Skill> employeeSkills = new ArrayList<>();

                for (Skill skill : skills) {
                    employeeSkills.add(skill);
                }

                ((Employee)personDB).setSkills(employeeSkills);
            }

            return personRepository.save(personDB);
        }
        return null;
    }

    public Person getPersonById(Long employeeId) {
        return personRepository.findById(employeeId).orElse(null);
    }

    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }


    public void deletePerson(Long employeeId) {
        personRepository.deleteById(employeeId);
    }

    //project
    public void saveProject(Project project) {
        Iterable<Person> people = personRepository.findAllById(project.getEmployees().stream().map(Person::getId).collect(Collectors.toList()));

        List<Employee> employees = new ArrayList<>();

        for (Person person : people) {
            if (person instanceof Employee) {
                employees.add((Employee) person);
            }
        }
        project.setEmployees(new ArrayList<>(employees));

        projectRepository.save(project);
    }

    public Project updateProject(Project project, Long projectId) {
        Project projectDB = projectRepository.findById(projectId).orElse(null);

        if (projectDB != null) {
            if (project.getTitle() != null)
                projectDB.setTitle(project.getTitle());
            if (project.getRequirements() != null)
                projectDB.setRequirements((ArrayList<Skill>) project.getRequirements());
            if (project.getFinish() != null)
                projectDB.setFinish(project.getFinish());
            if (project.getEmployees() != null) {
                List<Person> people = project.getEmployees();
                List<Employee> employees = new ArrayList<>();

                for (Person person : people) {
                    if (person instanceof Employee) {
                        employees.add((Employee) person);
                    }
                }
                projectDB.setEmployees(new ArrayList<>(employees));
            }

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

    public void deleteProject(Project project) {
        projectRepository.deleteById(project.getId());
    }

    public Map<List<String>,Map<String,List<Boolean>>> getEmployeeCompatibility(Long projectId){
        Project project = projectRepository.findById(projectId).orElse(null);
        List<Person> employees =(List<Person>) personRepository.findAll();
        Map<String, List<Boolean>> compatibilities =  new HashMap<>();

        for(Person person: employees){
            ArrayList<Boolean> compatibility=new ArrayList<>();
            if(person instanceof Employee){
                for(Skill skill: project.getRequirements()){
                    compatibility.add(((Employee) person).getSkills().stream().anyMatch(s->s.getId().equals(skill.getId())));
                }
            }

            compatibilities.put(person.getIdentifier(),compatibility);
        }

        Map<List<String>,Map<String,List<Boolean>>> result = new HashMap<>();
        result.put(project.getRequirements().stream().map(Skill::getTitle).collect(Collectors.toList()), compatibilities);
        return result;
    }

    //skills
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return (List<Skill>) skillRepository.findAll();
    }

    //position
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    public Position getPositionById(Long positionId) {
        return positionRepository.findById(positionId).orElse(null);
    }

    public List<Position> getAllPositions() {
        return (List<Position>) positionRepository.findAll();
    }

    public Position updatePosition(Position position, Long positionId) {
        Position positionDB = positionRepository.findById(positionId).orElse(null);

        if (positionDB != null) {
            positionDB.setTitle(position.getTitle());
            positionDB.setDescription(position.getDescription());

            return positionRepository.save(positionDB);
        }
        return null;
    }

    public void deletePosition(Long positionId) {
        positionRepository.deleteById(positionId);
    }

    //endregion
}
