package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;
import com.thesis.service.interfaces.IThesisAppealService;
import com.thesis.service.interfaces.IThesisService;
import com.thesis.service.interfaces.IThesisSuggestionService;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class StudentAppealBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(StudentAppealBean.class.getName());

    @ManagedProperty("#{thesisAppealService}")
    private IThesisAppealService thesisAppealService;

    @ManagedProperty("#{thesisSuggestionService}")
    private IThesisSuggestionService thesisSuggestionService;

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    private List<ThesisAppeal> thesisAppealList;
    private ThesisAppeal selectedThesisAppeal;

    @PostConstruct
    public void init() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        setThesisAppealList(thesisAppealService.retrieveByThesisManager(thesisManager));
    }

    //FIXME : Bir öğrenci bir tez şablonuna en fazla bir kere başvurabilir.
    public void acceptThesisAppeal() {
        getSelectedThesisAppeal().setAccepted(Boolean.TRUE);
        RequestContext.getCurrentInstance().execute("PF('student_appeal_dialog').hide()");
        showMessage("Tez başvurusu kabul edildi!");
        thesisAppealService.update(getSelectedThesisAppeal());
        thesisService.createThesisWithActivity(getSelectedThesisAppeal());
    }

    public void declineThesisAppeal() {
        getSelectedThesisAppeal().setAccepted(Boolean.FALSE);
        RequestContext.getCurrentInstance().execute("PF('student_appeal_dialog').hide()");
        showMessage("Tez başvurusu reddedildi!");
        thesisAppealService.update(getSelectedThesisAppeal());
    }

    public IThesisAppealService getThesisAppealService() {
        return thesisAppealService;
    }

    public void setThesisAppealService(IThesisAppealService thesisAppealService) {
        this.thesisAppealService = thesisAppealService;
    }

    public List<ThesisAppeal> getThesisAppealList() {
        return thesisAppealList;
    }

    public void setThesisAppealList(List<ThesisAppeal> thesisAppealList) {
        this.thesisAppealList = thesisAppealList;
    }

    public IThesisSuggestionService getThesisSuggestionService() {
        return thesisSuggestionService;
    }

    public void setThesisSuggestionService(IThesisSuggestionService thesisSuggestionService) {
        this.thesisSuggestionService = thesisSuggestionService;
    }

    public ThesisAppeal getSelectedThesisAppeal() {
        return selectedThesisAppeal;
    }

    public void setSelectedThesisAppeal(ThesisAppeal selectedThesisAppeal) {
        this.selectedThesisAppeal = selectedThesisAppeal;
    }

    public IThesisService getThesisService() {
        return thesisService;
    }

    public void setThesisService(IThesisService thesisService) {
        this.thesisService = thesisService;
    }
}
