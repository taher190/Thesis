package com.thesis.repository.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractRepository<T extends IEntity> extends HibernateDaoSupport implements IAbstractRepository<T> {

    @Autowired
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }
}
