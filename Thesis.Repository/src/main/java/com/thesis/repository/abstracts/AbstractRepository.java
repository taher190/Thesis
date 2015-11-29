package com.thesis.repository.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import static org.jodah.typetools.TypeResolver.resolveRawArguments;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractRepository<T extends IEntity> extends HibernateDaoSupport implements IAbstractRepository<T> {

    private Class<T> entityClass;

    public AbstractRepository() {
        this.entityClass = ((Class<T>) resolveRawArguments(AbstractRepository.class, getClass())[0]);
    }

    @Autowired
    public void setHibernateTemplate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity){
        getHibernateTemplate().update(entity);
    }

    public void delete(T entity){
        getHibernateTemplate().delete(entity);
    }
}
