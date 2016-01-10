package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;

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

    @ManyToOne
    private ThesisManager thesisManager;

    private Integer quota;

    @OneToMany(mappedBy = "season")
    private List<ThesisTemplate> thesisTemplateList;

    @OneToMany(mappedBy = "season")
    private List<ThesisSuggestion> thesisSuggestionList;

    @ManyToOne
    private Season season;

    private Date startDate;

    private Date endDate;

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

    public ThesisManager getThesisManager() {
        return thesisManager;
    }

    public void setThesisManager(ThesisManager thesisManager) {
        this.thesisManager = thesisManager;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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
}