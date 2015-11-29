package com.thesis.service.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import com.thesis.service.interfaces.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Transactional(propagation = Propagation.REQUIRED, value = "transactionManager")
public abstract class AbstractService<T extends IEntity> implements IAbstractService<T> {

    private IAbstractRepository<T> abstractRepository;

    @Autowired
    public AbstractService(IAbstractRepository abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    @Override
    public void save(T entity) {
        abstractRepository.save(entity);
    }
}
