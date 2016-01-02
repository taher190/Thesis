package com.thesis.repository.interfaces;

import com.thesis.model.abstracts.IEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAbstractRepository<T extends IEntity> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    T retrieveById(Long id);

    List<T> retrieveAll();
}
