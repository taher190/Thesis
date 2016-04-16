package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;
import com.thesis.model.ThesisTemplate;
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
        showMessage("Tez önerisi kabul edildi.");
    }

    public void dismiss() {
        selectedThesisSuggestion.setAccepted(Boolean.FALSE);
        thesisSuggestionService.update(selectedThesisSuggestion);
        showMessage("Tez önerisi reddedildi.");
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
}
