package com.thesis.repository;

import com.thesis.model.Notification;
import com.thesis.model.Role;
import com.thesis.model.abstracts.User;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.INotificationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class NotificationRepository extends AbstractRepository<Notification> implements INotificationRepository {

    @Override
    public List<Notification> retrieveMyNotifications(User assigned) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Notification> criteria = builder.createQuery(Notification.class);
        Root<Notification> notificationRoot = criteria.from(Notification.class);
        criteria.select(notificationRoot);
        criteria.where(builder.equal(notificationRoot.get("assigned"), assigned));
        criteria.orderBy(builder.desc(notificationRoot.get("createdDate")));
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
