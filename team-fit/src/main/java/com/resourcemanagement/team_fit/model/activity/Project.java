package com.resourcemanagement.team_fit.model.activity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.basic.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Project implements IActivity {
    private String title;
    private ArrayList<Skill> skills = new ArrayList<>();
    private ArrayList<Person> employees=new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date finish;

    public Project(){}
    public Project(String title, ArrayList<Skill> skills, ArrayList<Person> employees, Date start, Date finish) {
        this.title = title;
        this.skills = skills;
        this.employees = employees;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String getDescription() {
        return "Proiectul " + title + getSkills();
    }

    @Override
    public String getDuration() {
        return "Durata: " + getYears();
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    private long getYears() {
        return (finish.getTime()-start.getTime())/ (1000l*60*60*24*365);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public ArrayList<Person> getEmployees() {
        return employees;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }



    public void setEmployees(ArrayList<Person> employees) {
        this.employees = employees;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }
}
