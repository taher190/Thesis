package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.service.interfaces.IThesisTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ThesisTemplateBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ThesisTemplateBean.class.getName());

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    //save mode
    private ThesisTemplate thesisTemplate;

    //edit mode
    private ThesisTemplate selectedThesisTemplate;
    private List<ThesisTemplate> thesisTemplateList;

    public ThesisTemplateBean() {
        setThesisTemplate(new ThesisTemplate());
    }

    public void save() {
        thesisTemplateService.save(thesisTemplate);
        setThesisTemplate(new ThesisTemplate());
        logger.info("ThesisTemplate({}) saved!", thesisTemplate);
    }

    public void loadMyThesisTemplateList() {
        //FIXME : O anda oturum açan tez yöneticisinin tez şablonları getirilmeli!
        ThesisManager thesisManager = null;
        setThesisTemplateList(thesisTemplateService.retrieveByThesisManager(thesisManager));
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

    public ThesisTemplate getSelectedThesisTemplate() {
        return selectedThesisTemplate;
    }

    public void setSelectedThesisTemplate(ThesisTemplate selectedThesisTemplate) {
        this.selectedThesisTemplate = selectedThesisTemplate;
    }
}
