package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Student;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisTemplate;
import com.thesis.service.interfaces.IThesisAppealService;
import com.thesis.service.interfaces.IThesisTemplateService;
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
public class ThesisAppealBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ThesisAppealBean.class.getName());

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    @ManagedProperty("#{thesisAppealService}")
    private IThesisAppealService thesisAppealService;

    private ThesisTemplate selectedThesisTemplate;

    private ThesisAppeal thesisAppeal;

    private List<ThesisTemplate> thesisTemplateList;

    @PostConstruct
    public void init() {
        setThesisAppeal(new ThesisAppeal());
    }

    public void loadThesisTemplatesByStudent() {
        Student student = (Student) getLoggedInUser();
        setThesisTemplateList(thesisTemplateService.retrieveByStudent(student));
    }
    public void appeal() {
        Student student = (Student) getLoggedInUser();
        thesisAppeal.setStudent(student);
        thesisAppeal.setThesisTemplate(getSelectedThesisTemplate());
        thesisAppealService.save(thesisAppeal);
        logger.info("ThesisAppeal({}) has been saved!", thesisAppeal);
        showMessage("Tez başvurusu başarıyla gerçekleştirildi!");
    }

    public void selectThesisTemplate() {
        logger.info("ThesisTemplate({}) selected!", selectedThesisTemplate);
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
}
