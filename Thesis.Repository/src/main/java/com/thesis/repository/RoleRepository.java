package com.thesis.repository;

import com.thesis.model.Role;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IRoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class RoleRepository extends AbstractRepository<Role> implements IRoleRepository {

    @Override
    public Role retrieveByCode(String role) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        Root<Role> roleRoot = criteria.from(Role.class);
        criteria.select(roleRoot);
        criteria.where(builder.equal(roleRoot.get("code"), role));
        return getEntityManager().createQuery(criteria).getSingleResult();
    }
}
