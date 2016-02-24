package com.thesis.controller.util;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.ThesisAppeal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ApplicationScoped
public class ViewUtilBean extends AbstractBean {

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
}
