package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
public class ThesisManager extends User<ThesisManager> {

    @Column(unique = true)
    private String entryCode;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }
}
