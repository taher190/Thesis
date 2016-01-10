package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class RegisterBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(RegisterBean.class.getName());

    private static final String LOGIN_PAGE = "/pages/public/login.xhtml";

    @ManagedProperty("#{userService}")
    private IUserService userService;

    private RegisterType selectedRegisterType;

    private Student student;
    private ThesisManager thesisManager;

    public RegisterBean() {
        setSelectedRegisterType(RegisterType.STUDENT);
    }

    @PostConstruct
    public void init() {
        setThesisManager(new ThesisManager());
        setStudent(new Student());
    }

    public String save() {
        if(RegisterType.STUDENT.equals(selectedRegisterType)) {
            userService.save(student);
            logger.info("Student({}) has been saved!", student);
        } else if(RegisterType.THESIS_MANAGER.equals(selectedRegisterType)) {
            userService.save(thesisManager);
            logger.info("ThesisManager({}) has been saved!", thesisManager);
        }
        showMessage("İşlem başarıyla tamamlandı!");
        return LOGIN_PAGE;
    }

    public RegisterType[] getRegisterTypes() {
        return RegisterType.values();
    }

    public RegisterType getSelectedRegisterType() {
        return selectedRegisterType;
    }

    public void setSelectedRegisterType(RegisterType selectedRegisterType) {
        this.selectedRegisterType = selectedRegisterType;
    }

    public ThesisManager getThesisManager() {
        return thesisManager;
    }

    public void setThesisManager(ThesisManager thesisManager) {
        this.thesisManager = thesisManager;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public IUserService getUserService() {
        return userService;
    }

    @Override
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public enum RegisterType{
        STUDENT("Öğrenci"),
        THESIS_MANAGER("Tez Yöneticisi");

        private String label;

        private RegisterType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
