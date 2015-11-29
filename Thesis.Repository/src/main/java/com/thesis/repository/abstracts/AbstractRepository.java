package com.thesis.repository.abstracts;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractRepository extends HibernateDaoSupport {

    @Autowired
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
