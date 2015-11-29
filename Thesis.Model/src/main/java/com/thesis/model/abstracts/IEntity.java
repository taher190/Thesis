package com.thesis.model.abstracts;

import java.io.Serializable;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IEntity<T extends Serializable> extends Serializable {

    Long getId();

    void setId(Long id);
}
