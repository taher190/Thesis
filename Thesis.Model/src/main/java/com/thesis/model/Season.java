package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
public class Season extends AbstractEntity<Season> {

    private Integer quota;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private List<ThesisTemplate> thesisTemplateList;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private List<ThesisSuggestion> thesisSuggestionList;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private ThesisManager thesisManager;

    public List<ThesisSuggestion> getThesisSuggestionList() {
        return thesisSuggestionList;
    }

    public void setThesisSuggestionList(List<ThesisSuggestion> thesisSuggestionList) {
        this.thesisSuggestionList = thesisSuggestionList;
    }

    public List<ThesisTemplate> getThesisTemplateList() {
        return thesisTemplateList;
    }

    public void setThesisTemplateList(List<ThesisTemplate> thesisTemplateList) {
        this.thesisTemplateList = thesisTemplateList;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ThesisManager getThesisManager() {
        return thesisManager;
    }

    public void setThesisManager(ThesisManager thesisManager) {
        this.thesisManager = thesisManager;
    }
}