package com.thesis.repository;

import com.thesis.model.Role;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IRoleRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class RoleRepository extends AbstractRepository<Role> implements IRoleRepository {
}
