package com.thesis.repository;

import com.thesis.model.User;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class UserRepository extends AbstractRepository<User> implements IUserRepository {
}
