package com.thesis.service.interfaces;

import com.thesis.model.StudentActivity;
import com.thesis.model.abstracts.IEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAbstractService<T extends IEntity> extends Serializable {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    T retrieveById(Long id);

    List<T> retrieveAll();

    void refresh(T entity);
}
