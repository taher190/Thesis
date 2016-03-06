package com.thesis.repository;

import com.thesis.model.Student;
import com.thesis.model.Thesis;
import com.thesis.model.ThesisManager;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisRepository extends AbstractRepository<Thesis> implements IThesisRepository {

    @Override
    public List<Thesis> retrieveCurrentThesis(Student student) {
        Date now = new Date();

        StringBuilder hql = new StringBuilder();
        hql.append("FROM Thesis thesis ");
        hql.append("WHERE thesis.student = :student ");
        hql.append("AND thesis.thesisTemplate.season.startDate < :now ");
        hql.append("AND thesis.thesisTemplate.season.endDate > :now ");

        return getEntityManager().createQuery(hql.toString())
                .setParameter("student", student)
                .setParameter("now", now)
                .getResultList();
    }

    @Override
    public List<Thesis> retrieveCurrentThesis(ThesisManager thesisManager) {
        Date now = new Date();

        StringBuilder hql = new StringBuilder();
        hql.append("FROM Thesis thesis ");
        hql.append("WHERE thesis.thesisTemplate.thesisManager = :thesisManager ");
        hql.append("AND thesis.thesisTemplate.season.startDate < :now ");
        hql.append("AND thesis.thesisTemplate.season.endDate > :now ");

        return getEntityManager().createQuery(hql.toString())
                .setParameter("thesisManager", thesisManager)
                .setParameter("now", now)
                .getResultList();
    }
}
