package com.thesis.provider;

import com.thesis.model.abstracts.User;
import com.thesis.provider.interfaces.IAuthenticationProvider;
import com.thesis.repository.interfaces.IFacultyRepository;
import com.thesis.repository.interfaces.IUserRepository;
import com.thesis.statics.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
public class SpringSecurityAuthenticationProvider implements IAuthenticationProvider, UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(SpringSecurityAuthenticationProvider.class.getName());

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.retrieveUserByEntryVal(username);
            Collection authoritieSet = new HashSet();
            if("oguzfindik".equals(user.getEntryVal())
                    || "yasinortakci".equals(user.getEntryVal())
                    || "burhanselçuk".equals(user.getEntryVal())
                    || "yukselcelik".equals(user.getEntryVal())
                    || "safakbayir".equals(user.getEntryVal())
                    ) {
                authoritieSet.add(new GrantedAuthorityImpl("ROLE_THESIS_MANAGER"));
            } else if("admin".equals(user.getEntryVal())) {
                authoritieSet.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
            } else {
                authoritieSet.add(new GrantedAuthorityImpl("ROLE_STUDENT"));
            }
            authoritieSet.add(new GrantedAuthorityImpl("ROLE_USER"));
            /* FIXME : Yetkiler dinamik hale getirilmelli! */
            /*for(Role role : user.getRoleList()) {
                authoritieSet.add(new GrantedAuthorityImpl(role.getCode()));
            }*/
            return new org.springframework.security.core.userdetails.User(
                    user.getEntryVal(),
                    user.getPassword(),
                    authoritieSet);
        } catch (NoResultException ex) {
            logger.info("String({}) not found in database!", username);
            throw new UsernameNotFoundException(Messages.WRONG_USER_NAME);
        }
    }
}
