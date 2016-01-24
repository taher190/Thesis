package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Department;
import com.thesis.model.Faculty;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.Title;
import com.thesis.service.interfaces.IDepartmentService;
import com.thesis.service.interfaces.IFacultyService;
import com.thesis.service.interfaces.ITitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ApplicationBean.class.getName());

    @ManagedProperty("#{facultyService}")
    private IFacultyService facultyService;

    @ManagedProperty("#{departmentService}")
    private IDepartmentService departmentService;

    @ManagedProperty("#{titleService}")
    private ITitleService titleService;

    private List<Faculty> facultyList;
    private List<Department> departmentList;
    private List<Title> titleList;

    @PostConstruct
    public void init() {
        try {
            setFacultyList(facultyService.retrieveAll());
            setDepartmentList(departmentService.retrieveAll());
            setTitleList(titleService.retrieveAll());
        } catch (Exception ex) {
            logger.error("ApplicationBean class failed, result: {}", ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String getRowStyleClass(ThesisAppeal thesisAppeal) {
        if(thesisAppeal.getAccepted() == null) {
            return "";
        }

        if(thesisAppeal.getAccepted()) {
            return "appeal_accepted";
        } else {
            return "appeal_denied";
        }
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public IFacultyService getFacultyService() {
        return facultyService;
    }

    public void setFacultyService(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public IDepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public ITitleService getTitleService() {
        return titleService;
    }

    public void setTitleService(ITitleService titleService) {
        this.titleService = titleService;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }
}
