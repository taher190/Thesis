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

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Department> departmentList;

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
}
