package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class ThesisTemplate extends AbstractEntity<ThesisTemplate> {

    @Column(unique = true)
    private String name;

    @ManyToOne
    private ThesisManager thesisManager;

    @ManyToOne
    private Faculty faculty;

    private Boolean active;

    private String description;

    @ManyToOne
    private Season season;

    public ThesisManager getThesisManager() {
        return thesisManager;
    }

    public void setThesisManager(ThesisManager thesisManager) {
        this.thesisManager = thesisManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
