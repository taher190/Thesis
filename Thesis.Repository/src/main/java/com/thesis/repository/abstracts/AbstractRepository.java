package com.thesis.repository.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.jodah.typetools.TypeResolver.resolveRawArguments;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class
        AbstractRepository<T extends IEntity> implements IAbstractRepository<T> {

    private final Logger logger = LoggerFactory.getLogger(AbstractRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractRepository() {
        this.entityClass = ((Class<T>) resolveRawArguments(AbstractRepository.class, getClass())[0]);
    }

    @Override
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public void deleteById(Long id) {
        T entity = retrieveById(id);
        if(entity == null) {
            logger.warn("Entity({}) does not exist!");
            return;
        }
        delete(entity);
    }

    @Override
    public T retrieveById(Long id) {
        return getEntityManager().getReference(entityClass, id);
    }

    @Override
    public List<T> retrieveAll() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( entityClass );
        Root<T> entityRoot = criteria.from( entityClass );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}
