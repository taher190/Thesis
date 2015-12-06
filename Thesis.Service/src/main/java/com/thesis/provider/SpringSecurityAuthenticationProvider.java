package com.thesis.provider;

import com.thesis.model.Faculty;
import com.thesis.model.Role;
import com.thesis.model.abstracts.User;
import com.thesis.provider.interfaces.IAuthenticationProvider;
import com.thesis.repository.interfaces.IFacultyRepository;
import com.thesis.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public class SpringSecurityAuthenticationProvider implements IAuthenticationProvider, UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.retrieveUserByEntryVal(username);
        if(user == null) {
            return null;
        }
        Faculty faculty = facultyRepository.retrieveById(1L);
        Collection authoritieSet = new HashSet();
        for(Role role : (Set<Role>) user.getRoleSet()) {
            authoritieSet.add(new GrantedAuthorityImpl(role.getCode()));
        }
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getId()),
                user.getPassword(),
                authoritieSet);
    }

    @Override
    public User login(String entryValue, String password) {
        return null;
    }
}
