package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.service.interfaces.IFacultyService;
import com.thesis.service.interfaces.IRoleService;
import com.thesis.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(LoginBean.class.getName());

    @ManagedProperty("#{facultyService}")
    private IFacultyService facultyService;

    @ManagedProperty("#{roleService}")
    private IRoleService roleService;

    @ManagedProperty("#{userService}")
    private IUserService userService;

    public String getName() {
        return "Hello";
    }

    public IFacultyService getFacultyService() {
        return facultyService;
    }

    public void setFacultyService(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
