package com.thesis.repository;

import com.thesis.exception.InconsistentException;
import com.thesis.model.Season;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.ISeasonRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class SeasonRepository extends AbstractRepository<Season> implements ISeasonRepository {

    @Override
    public Season retrieveCurrentSeason(ThesisManager thesisManager) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Season> criteria = builder.createQuery(Season.class);
        Root<Season> seasonRoot = criteria.from(Season.class);
        criteria.select(seasonRoot);
        Predicate greaterDateCond = builder.greaterThanOrEqualTo(seasonRoot.<Date>get("endDate"), new Date());
        Predicate lessDateCond = builder.lessThanOrEqualTo(seasonRoot.<Date>get("startDate"), new Date());
        Predicate thesisManagerCond = builder.equal(seasonRoot.get("thesisManager"), thesisManager);
        criteria.where(builder.and(
                greaterDateCond,
                lessDateCond,
                thesisManagerCond));
        List<Season> seasonList = getEntityManager().createQuery(criteria).getResultList();
        if(CollectionUtils.isEmpty(seasonList)) {
            return null;
        }

        if(seasonList.size() == 1){
            return seasonList.get(0);
        }

        throw new InconsistentException("Aynı tarihler arasında sadece birden fazla tez sezonu oluşturulamaz!");
    }

    @Override
    public boolean hasSeasonFor(Date startDate, Date endDate, ThesisManager thesisManager) {

        StringBuilder hql = new StringBuilder();
        hql.append("FROM Season season ");
        hql.append("WHERE ((season.startDate < :startDate AND season.endDate > :startDate) ");
        hql.append("OR (season.startDate < :endDate AND season.endDate > :endDate))");
        hql.append("AND season.thesisManager = :thesisManager");

        Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("thesisManager", thesisManager);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return !CollectionUtils.isEmpty(query.getResultList());
    }
}
