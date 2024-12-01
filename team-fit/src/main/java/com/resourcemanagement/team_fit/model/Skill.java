package com.resourcemanagement.team_fit.model;

import com.resourcemanagement.team_fit.model.enums.Level;

public class Skill {
    private String title;
    private Level Level;

    public Skill(String title, Level level) {
        this.title = title;
        Level = level;
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
