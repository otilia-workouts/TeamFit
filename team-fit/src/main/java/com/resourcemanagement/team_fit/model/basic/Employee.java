package com.resourcemanagement.team_fit.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;
import jakarta.persistence.*;

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
    @JoinTable(
            name = "employees_skills",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
    private Integer yearsOfExperience;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    @JsonIgnore
    private List<Project> pastProjects;

    public Employee(String lastName, String firstName, String email, String address, Integer age, boolean married, Position position,
                    List<Skill> skills, Integer yearsOfExperience, List<Project> pastProjects) {
        super(lastName,firstName,email,address,age,married);
        this.position=position;
        this.skills=skills;
        this.yearsOfExperience=yearsOfExperience;
        this.pastProjects=pastProjects;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Project> getPastProjects() {
        return pastProjects;
    }
    public void setPastProjects(List<Project> pastProjects) {
        this.pastProjects = pastProjects;
    }

    @Override
    public String getResponsabilities() {
        return "Rezolvarea sarcinilor, realizarea proceselor verbale, participarea la sedinte.";
    }

    @Override
    public String getIdentifier() {
        return "employee_" + super.getIdentifier();
    }
}
