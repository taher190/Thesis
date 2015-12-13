package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
@DiscriminatorValue("2")
public class ThesisManager extends User<ThesisManager> {

    @OneToMany(mappedBy = "thesisManager")
    private List<ThesisTemplate> thesisTemplates;

    public List<ThesisTemplate> getThesisTemplates() {
        return thesisTemplates;
    }

    public void setThesisTemplates(List<ThesisTemplate> thesisTemplates) {
        this.thesisTemplates = thesisTemplates;
    }
}
