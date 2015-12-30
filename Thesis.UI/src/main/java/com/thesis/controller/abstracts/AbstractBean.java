package com.thesis.controller.abstracts;

import com.thesis.controller.ApplicationBean;
import com.thesis.model.Department;
import com.thesis.model.Faculty;

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
}
