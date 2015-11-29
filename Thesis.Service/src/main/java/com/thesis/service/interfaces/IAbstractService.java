package com.thesis.service.interfaces;

import com.thesis.model.abstracts.IEntity;

import java.io.Serializable;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAbstractService<T extends IEntity> extends Serializable {

    void save(T entity);
}
