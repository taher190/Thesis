package com.thesis.provider.interfaces;

import com.thesis.model.abstracts.User;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public interface IAuthenticationProvider {

    User login(String entryValue, String password);
}
