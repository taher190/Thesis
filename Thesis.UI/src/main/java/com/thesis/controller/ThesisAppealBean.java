package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.exception.SeasonNotFoundException;
import com.thesis.model.*;
import com.thesis.service.interfaces.IThesisAppealService;
import com.thesis.service.interfaces.IThesisManagerService;
import com.thesis.service.interfaces.IThesisSuggestionService;
import com.thesis.service.interfaces.IThesisTemplateService;
import com.thesis.statics.Messages;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ThesisAppealBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ThesisAppealBean.class.getName());

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    @ManagedProperty("#{thesisAppealService}")
    private IThesisAppealService thesisAppealService;

    @ManagedProperty("#{thesisManagerService}")
    private IThesisManagerService thesisManagerService;

    @ManagedProperty("#{thesisSuggestionService}")
    private IThesisSuggestionService thesisSuggestionService;

    private ThesisTemplate selectedThesisTemplate;
    private ThesisManager selectedThesisManager;
    private Student currentStudent;

    private ThesisAppeal thesisAppeal;
    private ThesisSuggestion thesisSuggestion;
    private int remainingLimitOfThesisManager;

    private List<ThesisTemplate> thesisTemplateList;
    private List<ThesisManager> thesisManagerList;

    @PostConstruct
    public void init() {
        setThesisAppeal(new ThesisAppeal());
        setThesisSuggestion(new ThesisSuggestion());
        currentStudent = (Student) getLoggedInUser();
    }

    public void loadThesisManagers() {
        Student student = (Student) getLoggedInUser();
        setThesisManagerList(thesisManagerService.retrieveByDepartment(student.getDepartment()));
    }

    public void appeal() {
        if(!checkOnlyOneThesisAppeal()) {
            showMessage(Messages.MANY_THESIS_APPEAL_ATTEMPT);
            return;
        }
        if(checkLastThesisAppealDate()) {
            showMessage(Messages.EXPIRE_DATE_OF_THESIS_TEMPLATE);
            return;
        }
        thesisAppeal.setStudent(currentStudent);
        thesisAppeal.setThesisTemplate(getSelectedThesisTemplate());
        thesisAppealService.save(thesisAppeal);
        logger.info("ThesisAppeal({}) has been saved!", thesisAppeal);
        showMessage("Tez başvurusu başarıyla gerçekleştirildi!");
    }

    private boolean checkLastThesisAppealDate() {
        Date now = new Date();
        return now.compareTo(getSelectedThesisTemplate().getLastAppealDate()) > 0;
    }

    public boolean checkOnlyOneThesisAppeal() {
        return thesisAppealService.checkOnlyOneThesisAppeal(currentStudent);
    }

    public void suggest() {
        Student student = (Student) getLoggedInUser();
        thesisSuggestion.setStudent(student);
        thesisSuggestionService.save(thesisSuggestion);
        logger.info("ThesisSuggestion({}) has been saved!", thesisSuggestion);
        showMessage("Tez önerisi başarıyla gönderildi!");
        RequestContext.getCurrentInstance().execute("PF('thesis_suggestion_dialog').hide();");
    }

    public boolean isQuotaHasExpired(ThesisManager thesisManager) {
        try {
            return thesisAppealService.isQuotaHasExpired(thesisManager);
        } catch (SeasonNotFoundException ex) {
            return true;
        }
    }

    public void selectThesisTemplate() {
        logger.info("ThesisTemplate({}) selected!", selectedThesisTemplate);
        setRemainingLimitOfThesisManager(thesisAppealService.remainingLimitOfThesisManager(selectedThesisManager));
    }

    public IThesisTemplateService getThesisTemplateService() {
        return thesisTemplateService;
    }

    public void setThesisTemplateService(IThesisTemplateService thesisTemplateService) {
        this.thesisTemplateService = thesisTemplateService;
    }
    public List<ThesisTemplate> getThesisTemplateList() {
        return thesisTemplateList;
    }

    public void setThesisTemplateList(List<ThesisTemplate> thesisTemplateList) {
        this.thesisTemplateList = thesisTemplateList;
    }

    public ThesisTemplate getSelectedThesisTemplate() {
        return selectedThesisTemplate;
    }

    public void setSelectedThesisTemplate(ThesisTemplate selectedThesisTemplate) {
        this.selectedThesisTemplate = selectedThesisTemplate;
    }

    public IThesisAppealService getThesisAppealService() {
        return thesisAppealService;
    }

    public void setThesisAppealService(IThesisAppealService thesisAppealService) {
        this.thesisAppealService = thesisAppealService;
    }

    public ThesisAppeal getThesisAppeal() {
        return thesisAppeal;
    }

    public void setThesisAppeal(ThesisAppeal thesisAppeal) {
        this.thesisAppeal = thesisAppeal;
    }

    public IThesisManagerService getThesisManagerService() {
        return thesisManagerService;
    }

    public void setThesisManagerService(IThesisManagerService thesisManagerService) {
        this.thesisManagerService = thesisManagerService;
    }

    public List<ThesisManager> getThesisManagerList() {
        return thesisManagerList;
    }

    public void setThesisManagerList(List<ThesisManager> thesisManagerList) {
        this.thesisManagerList = thesisManagerList;
    }

    public ThesisManager getSelectedThesisManager() {
        return selectedThesisManager;
    }

    public void setSelectedThesisManager(ThesisManager selectedThesisManager) {
        this.selectedThesisManager = selectedThesisManager;
    }

    public IThesisSuggestionService getThesisSuggestionService() {
        return thesisSuggestionService;
    }

    public void setThesisSuggestionService(IThesisSuggestionService thesisSuggestionService) {
        this.thesisSuggestionService = thesisSuggestionService;
    }

    public ThesisSuggestion getThesisSuggestion() {
        return thesisSuggestion;
    }

    public void setThesisSuggestion(ThesisSuggestion thesisSuggestion) {
        this.thesisSuggestion = thesisSuggestion;
    }

    public int getRemainingLimitOfThesisManager() {
        return remainingLimitOfThesisManager;
    }

    public void setRemainingLimitOfThesisManager(int remainingLimitOfThesisManager) {
        this.remainingLimitOfThesisManager = remainingLimitOfThesisManager;
    }
}
