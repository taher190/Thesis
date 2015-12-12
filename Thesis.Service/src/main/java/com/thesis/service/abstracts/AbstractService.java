package com.thesis.service.abstracts;

import com.thesis.model.abstracts.IEntity;
import com.thesis.repository.interfaces.IAbstractRepository;
import com.thesis.service.interfaces.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void update(T entity) {
        abstractRepository.update(entity);
    }

    @Override
    public void delete(T entity) {
        abstractRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        abstractRepository.deleteById(id);
    }

    @Override
    public T retrieveById(Long id) {
        return abstractRepository.retrieveById(id);
    }

    @Override
    public List<T> retrieveAll() {
        return abstractRepository.retrieveAll();
    }
}
