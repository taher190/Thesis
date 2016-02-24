package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class StudentActivity extends AbstractEntity<StudentActivity> {

    @ManyToOne
    private Thesis thesis;

    private String documentUrl;

    @OneToMany(mappedBy = "studentActivity", cascade = CascadeType.ALL)
    private List<StudentActivityComment> studentActivityCommentList;

    private Boolean accepted;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<StudentActivityComment> getStudentActivityCommentList() {
        return studentActivityCommentList;
    }

    public void setStudentActivityCommentList(List<StudentActivityComment> studentActivityCommentList) {
        this.studentActivityCommentList = studentActivityCommentList;
    }
}
