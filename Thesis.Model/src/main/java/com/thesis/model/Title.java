package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class Title extends AbstractEntity<Title> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
