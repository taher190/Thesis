package com.thesis.service;

import com.thesis.model.abstracts.User;
import com.thesis.repository.interfaces.IUserRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Autowired
    public UserService(IUserRepository userRepository) {
        super(userRepository);
    }
}
