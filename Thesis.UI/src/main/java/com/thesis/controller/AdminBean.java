package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Faculty;
import com.thesis.model.ThesisManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class AdminBean extends AbstractBean {

    private Faculty selectedFaculty;
    private ThesisManager selectedThesisManager;

    public void assignQuota() {

    }
}
