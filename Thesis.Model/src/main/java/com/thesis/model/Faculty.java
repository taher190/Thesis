package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
public class Faculty extends AbstractEntity<Faculty> {

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departmentList;

    @OneToMany(mappedBy = "faculty")
    private List<ThesisManager> thesisManagerList;

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

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<ThesisManager> getThesisManagerList() {
        return thesisManagerList;
    }

    public void setThesisManagerList(List<ThesisManager> thesisManagerList) {
        this.thesisManagerList = thesisManagerList;
    }
}
