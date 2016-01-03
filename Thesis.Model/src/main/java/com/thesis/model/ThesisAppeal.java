package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class ThesisAppeal extends AbstractEntity<ThesisAppeal> {

    @ManyToOne
    private ThesisTemplate thesisTemplate;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Topic topic;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ThesisTemplate getThesisTemplate() {
        return thesisTemplate;
    }

    public void setThesisTemplate(ThesisTemplate thesisTemplate) {
        this.thesisTemplate = thesisTemplate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


}
