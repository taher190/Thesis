package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
public class Department extends AbstractEntity<Department> {

    private String name;

    @Column(unique = true)
    private String code;

    @ManyToOne
    @Basic(fetch = FetchType.LAZY)
    private Faculty faculty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
