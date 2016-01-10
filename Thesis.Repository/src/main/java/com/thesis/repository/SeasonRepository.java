package com.thesis.repository;

import com.thesis.model.Season;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.ISeasonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class SeasonRepository extends AbstractRepository<Season> implements ISeasonRepository {

    @Override
    public Season retrieveCurrentSeason() {
        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Season> criteria = builder.createQuery(Season.class);
            Root<Season> seasonRoot = criteria.from(Season.class);
            criteria.select(seasonRoot);
            Predicate greaterDateCond = builder.greaterThanOrEqualTo(seasonRoot.<Date>get("endDate"), new Date());
            Predicate lessDateCond = builder.lessThanOrEqualTo(seasonRoot.<Date>get("startDate"), new Date());
            criteria.where( builder.and(
                    greaterDateCond,
                    lessDateCond));
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
