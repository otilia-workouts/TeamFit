package com.resourcemanagement.team_fit.model.basic;

import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.activity.Project;

import java.util.ArrayList;

public class Employee extends Person {

    private Position position;
    private ArrayList<Skill> skills;
    private Integer yearsOfExperience;
    private ArrayList<Project> pastProjects;

    public Employee(String lastName, String firstName, String email, String address, Integer age, boolean married) {
        super(lastName,firstName,email,address,age,married);
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
