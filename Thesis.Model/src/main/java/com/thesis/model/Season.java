package com.thesis.model;

import com.thesis.model.abstracts.AbstractEntity;
import org.apache.commons.lang.StringUtils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Calendar;
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

    private Integer numberOfWeek;

    @ManyToOne
    private ThesisManager thesisManager;

    public String getAlias() {
        StringBuilder alias = new StringBuilder();

        Calendar startDateCal = Calendar.getInstance();
        startDateCal.setTime(startDate);
        String startDay = StringUtils.leftPad(
                String.valueOf(startDateCal.get(Calendar.DAY_OF_MONTH)),
                2,
                "0");
        alias.append(startDay);
        alias.append(".");
        String startMonth = StringUtils.leftPad(
                String.valueOf(startDateCal.get(Calendar.MONTH) + 1),
                2,
                "0");
        alias.append(startMonth);
        alias.append(".");
        alias.append(startDateCal.get(Calendar.YEAR));
        alias.append(" - ");

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(endDate);
        String endDay = StringUtils.leftPad(
                String.valueOf(endDateCal.get(Calendar.DAY_OF_MONTH)),
                2,
                "0");
        alias.append(endDay);
        alias.append(".");
        String endMonth = StringUtils.leftPad(
                String.valueOf(endDateCal.get(Calendar.MONTH) + 1),
                2,
                "0");
        alias.append(endMonth);
        alias.append(".");
        alias.append(endDateCal.get(Calendar.YEAR));
        return alias.toString();
    }

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

    public Integer getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(Integer numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }
}