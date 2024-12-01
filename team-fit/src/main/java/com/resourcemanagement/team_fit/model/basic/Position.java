package com.resourcemanagement.team_fit.model.basic;

import com.resourcemanagement.team_fit.model.activity.Project;

public abstract class Position {
    private String title;
    private String description;

    public Position(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
