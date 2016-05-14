package com.thesis.service;

import com.thesis.model.Notification;
import com.thesis.model.abstracts.User;
import com.thesis.repository.interfaces.INotificationRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService extends AbstractService<Notification> implements INotificationService {

    private INotificationRepository notificationRepository;

    @Autowired
    public NotificationService(INotificationRepository notificationRepository) {
        super(notificationRepository);
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> retrieveMyNotifications(User assigned) {
        return notificationRepository.retrieveMyNotifications(assigned);
    }
}
