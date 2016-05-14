package com.thesis.model;

import com.thesis.enums.OperationType;
import com.thesis.model.abstracts.AbstractEntity;
import com.thesis.model.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Notification extends AbstractEntity<Notification> {

    private OperationType operationType;

    @ManyToOne
    private User reporter;

    @ManyToOne
    private User assigned;

    private String description;

    private boolean see;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public User getAssigned() {
        return assigned;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
    }

    public boolean isSee() {
        return see;
    }

    public void setSee(boolean see) {
        this.see = see;
    }
}
