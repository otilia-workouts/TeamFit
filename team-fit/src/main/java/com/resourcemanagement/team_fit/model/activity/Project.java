package com.resourcemanagement.team_fit.model.activity;


import com.resourcemanagement.team_fit.model.Skill;

import java.util.Date;
import java.util.List;

public class Project implements IActivity {
    private long id;
    private String name;
    private List<Skill> skills;

    private Date start;
    private Date finish;

    public Project(String name, List<Skill> skills, Date start, Date finish) {
        this.name = name;
        this.skills = skills;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String getDescription() {
        return "Proiectul " + name + getSkills();
    }

    @Override
    public String getDuration() {
        return "Durata: " + getYears();
    }

    private long getYears() {
        return (finish.getTime()-start.getTime())/ (1000l*60*60*24*365);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }
}
