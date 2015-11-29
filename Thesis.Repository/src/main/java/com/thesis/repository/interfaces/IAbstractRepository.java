package com.thesis.repository.interfaces;

import com.thesis.model.abstracts.IEntity;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAbstractRepository<T extends IEntity> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);
}
