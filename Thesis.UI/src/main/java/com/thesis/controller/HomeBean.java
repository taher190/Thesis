package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.Notification;
import com.thesis.model.abstracts.User;
import com.thesis.service.interfaces.INotificationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class HomeBean extends AbstractBean {

    @ManagedProperty("#{notificationService}")
    private INotificationService notificationService;

    private List<Notification> notificationList;

    public void init() {
        User user = getLoggedInUser();
        notificationList = notificationService.retrieveMyNotifications(user);
    }

    public void performSeeAllComments() {
        for(Notification notification : notificationList) {
            notification.setSee(Boolean.TRUE);
            notificationService.update(notification);
        }
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
