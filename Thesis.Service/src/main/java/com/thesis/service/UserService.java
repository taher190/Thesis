package com.thesis.service;

import com.thesis.model.Role;
import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.model.UserRole;
import com.thesis.model.abstracts.User;
import com.thesis.repository.interfaces.IRoleRepository;
import com.thesis.repository.interfaces.IUserRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IRoleService;
import com.thesis.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class UserService extends AbstractService<User> implements IUserService {

    private IUserRepository userRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User retrieveByName(String name) {
        return userRepository.retrieveUserByEntryVal(name);
    }

    @Override
    public void save(User user) {
        user.setActive(Boolean.FALSE);
        Role userRole = roleService.retrieveByCode("ROLE_USER");
        Role role = null;
        if(user instanceof Student) {
            role = roleService.retrieveByCode("ROLE_STUDENT");
        } else if(user instanceof ThesisManager) {
            role = roleService.retrieveByCode("ROLE_THESIS_MANAGER");
        }
        List<UserRole> userRoleList = new ArrayList<UserRole>();
        userRoleList.add(new UserRole(user, userRole));
        userRoleList.add(new UserRole(user, role));
        user.setUserRoleList(userRoleList);
        super.save(user);
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
}
