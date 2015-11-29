package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
public class Faculty extends AbstractEntity<Faculty> {

    private String name;

    @Column(unique = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
