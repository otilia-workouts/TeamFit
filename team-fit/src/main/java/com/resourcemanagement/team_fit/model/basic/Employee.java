package com.resourcemanagement.team_fit.model.basic;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Position position;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Skill> skills;
    private Integer yearsOfExperience;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> pastProjects;

    public Employee(String lastName, String firstName, String email, String address, Integer age, boolean married) {
        super(lastName,firstName,email,address,age,married);
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<Project> getPastProjects() {
        return pastProjects;
    }

    @Override
    public String getResponsabilities() {
        return "Rezolvarea arcinilor, realizarea proceselor verbale, participarea la sedinte.";
    }

    @Override
    public String getIdentifier() {
        return "employee_" + super.getIdentifier();
    }
}
