package com.thesis.controller;

import com.thesis.service.interfaces.IFacultyService;
import com.thesis.service.interfaces.IRoleService;
import com.thesis.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private final Logger logger = LoggerFactory.getLogger(LoginBean.class.getName());

    @ManagedProperty("#{facultyService}")
    private IFacultyService facultyService;

    @ManagedProperty("#{roleService}")
    private IRoleService roleService;

    @ManagedProperty("#{userService}")
    private IUserService userService;

    @PostConstruct
    public void init() {/*
        logger.info("call init method");

        Role role = new Role();
        role.setCode("ROLE_ADMIN");
        roleService.save(role);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        Student student = new Student();
        student.setName("asd");
        student.setActive(Boolean.TRUE);
        student.setPassword("pass");
        student.setSurname("dfdf");
        student.setRoleSet(roleSet);
        userService.save(student);*/
    }

    public void doLogin() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();
    }

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
