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

    @ManyToOne
    private Department department;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "thesistemplate_topic", joinColumns = {
            @JoinColumn(name = "thesistemplate_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "topic_id",
                    nullable = false, updatable = false) })
    private List<Topic> topicList;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
