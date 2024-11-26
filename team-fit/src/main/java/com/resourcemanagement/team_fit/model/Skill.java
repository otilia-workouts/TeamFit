package com.resourcemanagement.team_fit.model;

import com.resourcemanagement.team_fit.model.enums.Level;

public class Skill {
    private long id;
    private String name;
    private Level Level;

    public Skill(long id, String name, Level level) {
        this.id = id;
        this.name = name;
        Level = level;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.resourcemanagement.team_fit.model.enums.Level getLevel() {
        return Level;
    }

    public void setLevel(com.resourcemanagement.team_fit.model.enums.Level level) {
        Level = level;
    }
}
