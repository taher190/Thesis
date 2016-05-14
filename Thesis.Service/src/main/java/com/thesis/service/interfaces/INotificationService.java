package com.thesis.service.interfaces;

import com.thesis.model.Notification;
import com.thesis.model.abstracts.User;

import java.util.List;

public interface INotificationService extends IAbstractService<Notification> {

    List<Notification> retrieveMyNotifications(User assigned);
}
