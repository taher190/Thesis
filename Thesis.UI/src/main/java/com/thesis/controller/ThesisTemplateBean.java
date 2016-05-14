package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.controller.interfaces.ICRUDOperation;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.service.interfaces.INotificationService;
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
public class ThesisTemplateBean extends AbstractBean implements ICRUDOperation {

    private final Logger logger = LoggerFactory.getLogger(ThesisTemplateBean.class.getName());

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    //save mode
    private ThesisTemplate thesisTemplate;

    //edit mode
    private List<ThesisTemplate> thesisTemplateList;

    @PostConstruct
    public void init() {
        initThesisTemplate();
    }

    private void initThesisTemplate() {
        setThesisTemplate(new ThesisTemplate());
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        getThesisTemplate().setFaculty(thesisManager.getFaculty());
        getThesisTemplate().setThesisManager(thesisManager);
    }

    @Override
    public void save() {
        thesisTemplateService.save(thesisTemplate);
        initThesisTemplate();
        logger.info("ThesisTemplate({}) has been saved!", thesisTemplate);
        showMessage("Tez şablonu başarıyla kaydedildi!");
    }

    @Override
    public void update() {
        thesisTemplateService.update(thesisTemplate);
        logger.info("ThesisTemplate({}) has been updated!", thesisTemplate);
        showMessage("Tez şablonu başarıyla güncellendi!");
    }

    @Override
    public void delete() {
        thesisTemplateService.deleteById(thesisTemplate.getId());
        initThesisTemplate();
        logger.info("ThesisTemplate({}) has been deleted.");
        showMessage("Tez şablonu başarıyla silindi!");
    }

    public void loadMyThesisTemplateList() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        setThesisTemplateList(thesisTemplateService.retrieveByThesisManager(thesisManager));
    }

    public void selectThesisTemplate() {
        logger.info("ThesisTemplate({}) selected!", thesisTemplate);
    }

    public ThesisTemplate getThesisTemplate() {
        return thesisTemplate;
    }

    public void setThesisTemplate(ThesisTemplate thesisTemplate) {
        this.thesisTemplate = thesisTemplate;
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
}
