package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Thesis;
import com.thesis.model.ThesisManager;
import com.thesis.service.interfaces.IThesisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 *  Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class OldSeasonsBean extends AbstractBean {

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    private List<Thesis> thesisList;
    private Thesis thesis;

    public void init() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        List<Thesis> currentThesisList = thesisService.retrieveCurrentThesis(thesisManager);
        List<Thesis> thesisList = thesisService.retrieveByThesisManager(thesisManager);
        thesisList.removeAll(currentThesisList);
        setThesisList(thesisList);
    }

    public IThesisService getThesisService() {
        return thesisService;
    }

    public void setThesisService(IThesisService thesisService) {
        this.thesisService = thesisService;
    }

    public List<Thesis> getThesisList() {
        return thesisList;
    }

    public void setThesisList(List<Thesis> thesisList) {
        this.thesisList = thesisList;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
}
