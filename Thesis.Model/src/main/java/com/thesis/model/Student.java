package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
public class Student extends User<Student> {

    @Column(unique = true)
    private String studentNumber;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}