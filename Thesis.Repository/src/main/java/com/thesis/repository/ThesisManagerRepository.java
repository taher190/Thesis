package com.thesis.repository;

import com.thesis.model.Department;
import com.thesis.model.ThesisManager;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisManagerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisManagerRepository extends AbstractRepository<ThesisManager> implements IThesisManagerRepository {

    @Override
    public List<ThesisManager> retrieveByDepartment(Department department) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ThesisManager> criteria = builder.createQuery( ThesisManager.class );
        Root<ThesisManager> thesisManagerRoot = criteria.from( ThesisManager.class );
        criteria.select(thesisManagerRoot);
        criteria.where( builder.equal( thesisManagerRoot.get("department"), department ) );
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
