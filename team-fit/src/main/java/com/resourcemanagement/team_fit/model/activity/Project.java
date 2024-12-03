package com.resourcemanagement.team_fit.model.activity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.basic.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class Project implements IActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Skill> requirements = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Person> employees=new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date finish;

    public Project(){}
    public Project(String title, ArrayList<Skill> requirements, ArrayList<Person> employees, Date start, Date finish) {
        this.title = title;
        this.requirements = requirements;
        this.employees = employees;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String getDescription() {
        return "Proiectul " + getTitle() + " " + getRequirements();
    }

    @Override
    public String getDuration() {
        return "Durata: " + getYears();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public List<Skill> getRequirements() {
        return requirements;
    }
    public List<Person> getEmployees() {
        return employees;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRequirements(ArrayList<Skill> skills) {
        this.requirements = skills;
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
