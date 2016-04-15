package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;
import com.thesis.service.interfaces.IThesisSuggestionService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ThesisSuggestionBean extends AbstractBean {

    @ManagedProperty("#{thesisSuggestionService}")
    private IThesisSuggestionService thesisSuggestionService;

    private List<ThesisSuggestion> thesisSuggestionList;
    private ThesisSuggestion selectedThesisSuggestion;

    public void init() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        setThesisSuggestionList(thesisSuggestionService.retrieveByThesisManager(thesisManager));
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
}
