package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.enums.OperationType;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;
import com.thesis.model.ThesisTemplate;
import com.thesis.service.ThesisService;
import com.thesis.service.interfaces.IThesisService;
import com.thesis.service.interfaces.IThesisSuggestionService;
import com.thesis.service.interfaces.IThesisTemplateService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.BooleanConverter;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ThesisSuggestionBean extends AbstractBean {

    @ManagedProperty("#{thesisSuggestionService}")
    private IThesisSuggestionService thesisSuggestionService;

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    private List<ThesisSuggestion> thesisSuggestionList;
    private List<ThesisTemplate> thesisTemplateList;
    private ThesisSuggestion selectedThesisSuggestion;
    private ThesisTemplate selectedThesisTemplate;

    public void init() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        setThesisSuggestionList(thesisSuggestionService.retrieveByThesisManager(thesisManager));
        setThesisTemplateList(thesisTemplateService.retrieveByThesisManager(thesisManager));
    }

    public void accept() {
        selectedThesisSuggestion.setThesisTemplate(getSelectedThesisTemplate());
        selectedThesisSuggestion.setAccepted(Boolean.TRUE);
        thesisSuggestionService.update(selectedThesisSuggestion);
        thesisService.createThesisWithActivity(getSelectedThesisTemplate().getSeason(), getSelectedThesisSuggestion().getStudent(), getSelectedThesisTemplate());
        showMessage("Tez önerisi kabul edildi.");
        putNotificationRepo(getSelectedThesisSuggestion().getStudent(), getSelectedThesisSuggestion().getThesisManager(), OperationType.ACCEPTED_THESIS_SUGGESTION
                , getSelectedThesisSuggestion().getText());
    }

    public void dismiss() {
        selectedThesisSuggestion.setAccepted(Boolean.FALSE);
        thesisSuggestionService.update(selectedThesisSuggestion);
        showMessage("Tez önerisi reddedildi.");
        putNotificationRepo(getSelectedThesisSuggestion().getStudent(), getSelectedThesisSuggestion().getThesisManager(), OperationType.DISMISSED_THESIS_SUGGESTION
                , getSelectedThesisSuggestion().getText());
    }

    public IThesisSuggestionService getThesisSuggestionService() {
        return thesisSuggestionService;
    }

    public void setThesisSuggestionService(IThesisSuggestionService thesisSuggestionService) {
        this.thesisSuggestionService = thesisSuggestionService;
    }

    public ThesisSuggestion getSelectedThesisSuggestion() {
        return selectedThesisSuggestion;
    }

    public void setSelectedThesisSuggestion(ThesisSuggestion selectedThesisSuggestion) {
        this.selectedThesisSuggestion = selectedThesisSuggestion;
    }

    public List<ThesisSuggestion> getTheseisSuggestionList() {
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

    public IThesisTemplateService getThesisTemplateService() {
        return thesisTemplateService;
    }

    public void setThesisTemplateService(IThesisTemplateService thesisTemplateService) {
        this.thesisTemplateService = thesisTemplateService;
    }

    public ThesisTemplate getSelectedThesisTemplate() {
        return selectedThesisTemplate;
    }

    public void setSelectedThesisTemplate(ThesisTemplate selectedThesisTemplate) {
        this.selectedThesisTemplate = selectedThesisTemplate;
    }
    public IThesisService getThesisService() {
        return thesisService;
    }

    public void setThesisService(IThesisService thesisService) {
        this.thesisService = thesisService;
    }
}
