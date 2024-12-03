package com.resourcemanagement.team_fit.model;

import com.resourcemanagement.team_fit.model.basic.Employee;
import com.resourcemanagement.team_fit.model.enums.Level;
import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Level Level;

    @ManyToOne
    private Employee employee;

    public Skill() {

    }

    public Skill(String title, Level level) {
        this.title = title;
        Level = level;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public com.resourcemanagement.team_fit.model.enums.Level getLevel() {
        return Level;
    }

    public void setLevel(com.resourcemanagement.team_fit.model.enums.Level level) {
        Level = level;
    }
}
