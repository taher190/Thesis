package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.controller.interfaces.IThesisTemplateOperation;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.model.Topic;
import com.thesis.service.interfaces.IThesisTemplateService;
import com.thesis.service.interfaces.ITopicService;
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
public class ThesisTemplateBean extends AbstractBean implements IThesisTemplateOperation {

    private final Logger logger = LoggerFactory.getLogger(ThesisTemplateBean.class.getName());

    @ManagedProperty("#{thesisTemplateService}")
    private IThesisTemplateService thesisTemplateService;

    @ManagedProperty("#{topicService}")
    private ITopicService topicService;

    //save mode
    private ThesisTemplate thesisTemplate;

    //edit mode
    private List<ThesisTemplate> thesisTemplateList;

    private List<Topic> topicList;

    private List<Topic> selectedTopicList;

    @PostConstruct
    public void init() {
        initThesisTemplate();
    }

    private void initThesisTemplate() {
        setThesisTemplate(new ThesisTemplate());
        getThesisTemplate().setThesisManager((ThesisManager) getLoggedInUser());
        setTopicList(topicService.retrieveByFaculty(
                getThesisTemplate().getThesisManager().getFaculty()
        ));
    }

    @Override
    public void save() {
        thesisTemplateService.save(thesisTemplate);
        initThesisTemplate();
        logger.info("ThesisTemplate({}) has been saved!", thesisTemplate);
        logger.info("Tez şablonu başarıyla kaydedildi!");
    }

    @Override
    public void update() {
        //thesisTemplate.setTopicList(getSelectedTopicList());
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

    public ITopicService getTopicService() {
        return topicService;
    }

    public void setTopicService(ITopicService topicService) {
        this.topicService = topicService;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Topic> getSelectedTopicList() {
        return selectedTopicList;
    }

    public void setSelectedTopicList(List<Topic> selectedTopicList) {
        this.selectedTopicList = selectedTopicList;
    }
}
