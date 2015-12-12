package com.thesis.repository;

import com.thesis.model.User;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Override
    public User retrieveUserByEntryVal(String entryVal) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from( User.class );
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("entryVal"), entryVal));
        return getEntityManager().createQuery(criteria).getSingleResult();
    }
}
