package com.thesis.repository.interfaces;

import com.thesis.model.User;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IUserRepository extends IAbstractRepository<User> {

    User retrieveUserByEntryVal(String entryVal);
}
