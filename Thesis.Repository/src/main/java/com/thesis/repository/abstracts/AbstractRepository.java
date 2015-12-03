package com.thesis.repository.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

import static org.jodah.typetools.TypeResolver.resolveRawArguments;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public abstract class AbstractRepository<T extends IEntity> extends HibernateDaoSupport implements IAbstractRepository<T> {

    private final Logger logger = LoggerFactory.getLogger(AbstractRepository.class.getName());

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

    @Override
    public void delete(T entity){
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        T entity = retrieveById(id);
        if(entity == null) {
            logger.warn("Entity({}) does not exist!");
            return;
        }
        getHibernateTemplate().delete(entity);
    }

    @Override
    public T retrieveById(Long id) {
        return getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public List<T> retrieveAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }
}
