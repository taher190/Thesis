package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.StudentActivity;
import com.thesis.model.Thesis;
import com.thesis.service.interfaces.IThesisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ViewThesisBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ViewThesisBean.class.getName());

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    private Thesis thesis;
    private StudentActivity selectedStudentActivity;

    //FIXME : Exception handle edilmeli!
    @PostConstruct
    public void init() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long thesisId = Long.parseLong(requestMap.get("thesis_id").toString());
        setThesis(thesisService.retrieveById(thesisId));
    }

    public IThesisService getThesisService() {
        return thesisService;
    }

    public void setThesisService(IThesisService thesisService) {
        this.thesisService = thesisService;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    public StudentActivity getSelectedStudentActivity() {
        return selectedStudentActivity;
    }

    public void setSelectedStudentActivity(StudentActivity selectedStudentActivity) {
        this.selectedStudentActivity = selectedStudentActivity;
    }
}
