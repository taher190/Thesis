package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;
import com.thesis.model.abstracts.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class StudentActivityComment extends AbstractEntity<StudentActivityComment> {

    @ManyToOne
    private StudentActivity studentActivity;

    @ManyToOne
    private User user;

    @Column(length = 1200)
    private String text;

    private Boolean saw;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudentActivity getStudentActivity() {
        return studentActivity;
    }

    public void setStudentActivity(StudentActivity studentActivity) {
        this.studentActivity = studentActivity;
    }

    public Boolean getSaw() {
        return saw;
    }

    public void setSaw(Boolean saw) {
        this.saw = saw;
    }
}
