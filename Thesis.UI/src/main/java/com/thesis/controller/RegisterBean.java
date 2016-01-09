package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Student;
import com.thesis.model.ThesisManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class RegisterBean extends AbstractBean {

    private RegisterType selectedRegisterType;

    private Student student;
    private ThesisManager thesisManager;

    public RegisterBean() {
        setSelectedRegisterType(RegisterType.STUDENT);
    }

    public void saveForStudent() {
        System.out.println(student);
    }

    public void saveForThesisManager() {
        System.out.println(thesisManager);
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
