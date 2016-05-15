package com.thesis.repository;

import com.thesis.model.Student;
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
import java.util.Date;
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

    @Override
    public boolean checkOnlyOneThesisAppeal(Student student) {
        Date now = new Date();

        StringBuilder hql = new StringBuilder();
        hql.append("FROM ThesisAppeal thesisAppeal ");
        hql.append("WHERE thesisAppeal.student = :student ");
        hql.append("AND thesisAppeal.thesisTemplate.season.startDate < :now ");
        hql.append("AND thesisAppeal.thesisTemplate.season.endDate > :now ");

        Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("student", student);
        query.setParameter("now", now);
        return query.getResultList().isEmpty();
    }

    @Override
    public void rejectOfAllThesisSuggestion(Student student) {
        StringBuilder hql = new StringBuilder();
        hql.append("UPDATE ThesisSuggestion thesisSuggestion ");
        hql.append("SET accepted = 0 ");
        hql.append("WHERE student = :student ");
        hql.append("AND accepted = null ");

        Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("student", student);
        query.executeUpdate();
    }

    @Override
    public void rejectOfAllThesisAppeal(Student student) {
        StringBuilder hql = new StringBuilder();
        hql.append("UPDATE ThesisAppeal thesisAppeal ");
        hql.append("SET accepted = 0 ");
        hql.append("WHERE student = :student ");
        hql.append("AND accepted = null ");

        Query query = getEntityManager().createQuery(hql.toString());
        query.setParameter("student", student);
        query.executeUpdate();
    }
}
