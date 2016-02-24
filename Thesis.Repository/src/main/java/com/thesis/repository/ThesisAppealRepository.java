package com.thesis.repository;

import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.Query;
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

        StringBuilder hql = new StringBuilder();
        //FIXME : sezon kritere eklenmeli
        hql.append("FROM ThesisAppeal thesisAppeal ");
        hql.append("WHERE thesisAppeal.thesisTemplate.thesisManager = :thesisManager ");

        Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("thesisManager", thesisManager);
        return query.getResultList();
    }
}
