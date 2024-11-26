package com.resourcemanagement.team_fit.model.basic;

import com.resourcemanagement.team_fit.model.activity.Project;

public abstract class Position {
    private String name;
    private String description;

    private Project project;

    public Position(String name, String description, Project project) {
        this.name = name;
        this.description = description;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
