package com.thesis.controller.util;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.StudentActivityComment;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.abstracts.AbstractEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ViewUtilBean extends AbstractBean {

    public String getRowStyleClass(Boolean accepted) {
        if(accepted == null) {
            return "";
        }

        if(accepted) {
            return "accepted";
        } else {
            return "denied";
        }
    }

    public List<?> getReverseList(List<?> itemList) {
        if(itemList == null) {
            return null;
        }
        Collections.reverse(itemList);
        return itemList;
    }
}
