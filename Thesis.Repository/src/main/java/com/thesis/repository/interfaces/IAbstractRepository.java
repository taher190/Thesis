package com.thesis.repository.interfaces;

import com.thesis.model.abstracts.IEntity;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAbstractRepository<T extends IEntity> {

    void save(T entity);
}
