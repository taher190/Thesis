package com.thesis.service;

import com.thesis.model.Role;
import com.thesis.repository.interfaces.IRoleRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Service
public class RoleService extends AbstractService<Role> implements IRoleService {

    private IRoleRepository roleRepository;

    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Role retrieveByCode(String role) {
        return roleRepository.retrieveByCode(role);
    }
}
