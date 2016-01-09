package com.thesis.repository;

import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisTemplateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisTemplateRepository extends AbstractRepository<ThesisTemplate> implements IThesisTemplateRepository {

    @Override
    public List<ThesisTemplate> retrieveByThesisManager(ThesisManager thesisManager) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ThesisTemplate> criteria = builder.createQuery( ThesisTemplate.class );
        Root<ThesisTemplate> thesisTemplateRoot = criteria.from( ThesisTemplate.class );
        criteria.select(thesisTemplateRoot);
        criteria.where( builder.equal( thesisTemplateRoot.get("thesisManager"), thesisManager ) );
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<ThesisTemplate> retrieveByStudent(Student student) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ThesisTemplate> criteria = builder.createQuery(ThesisTemplate.class);
        Root<ThesisTemplate> thesisTemplateRoot = criteria.from(ThesisTemplate.class);
        criteria.select(thesisTemplateRoot);
        Predicate activeCond = builder.equal(thesisTemplateRoot.get("active"), true);
        Predicate facultyCond = builder.equal(thesisTemplateRoot.get("faculty"), student.getFaculty());
        criteria.where( builder.and(
                activeCond,
                facultyCond));
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
