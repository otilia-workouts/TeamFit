package com.resourcemanagement.team_fit.model.basic;

import com.resourcemanagement.team_fit.model.activity.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @OneToOne
    private Employee employee;

    public Position(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Position() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
