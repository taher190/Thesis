package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
@DiscriminatorValue("2")
public class ThesisManager extends User<ThesisManager> {

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "thesisManager")
    private List<ThesisTemplate> thesisTemplateList;

    @ManyToOne
    private Title title;

    public List<ThesisTemplate> getThesisTemplateList() {
        return thesisTemplateList;
    }

    public void setThesisTemplateList(List<ThesisTemplate> thesisTemplateList) {
        this.thesisTemplateList = thesisTemplateList;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
