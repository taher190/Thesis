package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Student;
import com.thesis.model.Thesis;
import com.thesis.model.ThesisManager;
import com.thesis.model.abstracts.User;
import com.thesis.service.interfaces.IThesisService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ViewAllThesisBean extends AbstractBean {

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    private List<Thesis> thesisList;

    @PostConstruct
    public void init() {
        if(getLoggedInUser() instanceof Student) {
            setThesisList(thesisService.retrieveCurrentThesis((Student) getLoggedInUser()));
        } else if(getLoggedInUser() instanceof ThesisManager) {
            setThesisList(thesisService.retrieveCurrentThesis((ThesisManager) getLoggedInUser()));
        }
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


}
