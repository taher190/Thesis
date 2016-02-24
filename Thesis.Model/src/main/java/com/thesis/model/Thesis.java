package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class Thesis extends AbstractEntity<Thesis> {

    @ManyToOne
    private ThesisTemplate thesisTemplate;

    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<StudentActivity> studentActivityList;

    public ThesisTemplate getThesisTemplate() {
        return thesisTemplate;
    }

    public void setThesisTemplate(ThesisTemplate thesisTemplate) {
        this.thesisTemplate = thesisTemplate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentActivity> getStudentActivityList() {
        return studentActivityList;
    }

    public void setStudentActivityList(List<StudentActivity> studentActivityList) {
        this.studentActivityList = studentActivityList;
    }
}
