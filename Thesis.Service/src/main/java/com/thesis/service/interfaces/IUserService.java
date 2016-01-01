package com.thesis.service.interfaces;

import com.thesis.model.abstracts.User;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IUserService extends IAbstractService<User> {

    User retrieveByName(String name);
}
