package com.thesis.repository.interfaces;

import com.thesis.model.Notification;
import com.thesis.model.abstracts.User;

import java.util.List;

public interface INotificationRepository extends IAbstractRepository<Notification> {

    List<Notification> retrieveMyNotifications(User assigned);
}
