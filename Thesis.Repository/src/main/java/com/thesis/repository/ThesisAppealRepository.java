package com.thesis.repository;

import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisAppealRepository extends AbstractRepository<ThesisAppeal> implements IThesisAppealRepository {

    @Override
    public List<ThesisAppeal> retrieveByThesisManager(ThesisManager thesisManager) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ThesisAppeal> criteria = builder.createQuery( ThesisAppeal.class );
        Root<ThesisAppeal> thesisAppealRoot = criteria.from( ThesisAppeal.class );
        criteria.select(thesisAppealRoot);
        //FIXME : kriter düzeltilmeli.
        criteria.where( builder.equal( thesisAppealRoot.get("thesisTemplate"), thesisManager.getThesisTemplateList().get(0)) );
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
