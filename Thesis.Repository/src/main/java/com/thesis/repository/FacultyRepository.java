package com.thesis.repository;

import com.thesis.model.Faculty;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IFacultyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class FacultyRepository extends AbstractRepository<Faculty> implements IFacultyRepository {

    @Override
    public Faculty retrieveFacultyByCode(String code) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Faculty> criteria = builder.createQuery( Faculty.class );
        Root<Faculty> facultyRoot = criteria.from( Faculty.class );
        criteria.select(facultyRoot);
        criteria.where( builder.equal( facultyRoot.get( "code" ), code ) );
        return getEntityManager().createQuery(criteria).getSingleResult();
    }
}
