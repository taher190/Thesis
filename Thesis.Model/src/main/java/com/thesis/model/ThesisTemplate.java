package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class ThesisTemplate extends AbstractEntity<ThesisTemplate> {

    @Column(unique = true)
    private String name;

    @ManyToOne
    private ThesisManager thesisManager;

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

}
