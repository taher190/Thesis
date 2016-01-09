package com.thesis.controller.abstracts;

import com.thesis.controller.ApplicationBean;
import com.thesis.model.Department;
import com.thesis.model.Faculty;
import com.thesis.model.abstracts.User;
import com.thesis.service.interfaces.IUserService;
import org.primefaces.context.RequestContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractBean implements Serializable {

    protected static final String FACULTY_BEAN = "facultyBean";
    protected static final String DEPARTMENT_BEAN = "departmentBean";
    protected static final String APPLICATION_BEAN = "applicationBean";

    @ManagedProperty("#{userService}")
    private IUserService userService;

    protected <T> T getBean(String beanName) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (T) facesContext.getApplication()
                .getVariableResolver().resolveVariable(facesContext, beanName);
    }

    public List<Faculty> getFacultyList() {
        ApplicationBean applicationBean = getBean(APPLICATION_BEAN);
        return applicationBean.getFacultyList();
    }

    public List<Department> getDepartmentList() {
        ApplicationBean applicationBean = getBean(APPLICATION_BEAN);
        return applicationBean.getDepartmentList();
    }

    protected User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.retrieveByName(auth.getName());
    }

    protected void showMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        RequestContext.getCurrentInstance().update("common_growl");
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
