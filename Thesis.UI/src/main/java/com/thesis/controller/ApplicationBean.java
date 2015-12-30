package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Department;
import com.thesis.model.Faculty;
import com.thesis.service.interfaces.IDepartmentService;
import com.thesis.service.interfaces.IFacultyService;
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

    private List<Faculty> facultyList;
    private List<Department> departmentList;

    @PostConstruct
    public void init() {
        try {
            setFacultyList(facultyService.retrieveAll());
            setDepartmentList(departmentService.retrieveAll());
        } catch (Exception ex) {
            logger.error("ApplicationBean class failed, result: {}", ex.getMessage());
            ex.printStackTrace();
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
}
