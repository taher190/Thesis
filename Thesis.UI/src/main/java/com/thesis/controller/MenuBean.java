package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisManager;
import com.thesis.service.interfaces.ISeasonService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class MenuBean extends AbstractBean {

    @ManagedProperty("#{seasonService}")
    private ISeasonService seasonService;

    public boolean isCreatedSeasonAtNow() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        return seasonService.retrieveCurrentSeason(thesisManager) != null;
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
