package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class ThesisSuggestion extends AbstractEntity<ThesisSuggestion> {

    @Column(length = 400)
    private String text;

    @ManyToOne
    private Student student;

    private Boolean accepted;

    @ManyToOne
    private ThesisManager thesisManager;

    @ManyToOne
    private Season season;

    @ManyToOne
    private ThesisTemplate thesisTemplate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ThesisManager getThesisManager() {
        return thesisManager;
    }

    public void setThesisManager(ThesisManager thesisManager) {
        this.thesisManager = thesisManager;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ThesisTemplate getThesisTemplate() {
        return thesisTemplate;
    }

    public void setThesisTemplate(ThesisTemplate thesisTemplate) {
        this.thesisTemplate = thesisTemplate;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
