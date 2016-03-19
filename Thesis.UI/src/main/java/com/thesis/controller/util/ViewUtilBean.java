package com.thesis.controller.util;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.StudentActivityComment;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.abstracts.AbstractEntity;
import org.apache.commons.lang.time.DateUtils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Collections;
import java.util.Comparator;
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

    public List<AbstractEntity> getReverseList(List<AbstractEntity> itemList) {
        Collections.sort(itemList, new Comparator<AbstractEntity>() {
            @Override
            public int compare(AbstractEntity o1, AbstractEntity o2) {
                return (int) (o2.getCreatedDate().getTime() - o1.getCreatedDate().getTime());
            }
        });
        return itemList;
    }
}
