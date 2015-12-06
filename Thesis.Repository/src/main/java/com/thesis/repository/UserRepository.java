package com.thesis.repository;

import com.thesis.exception.InconsistentException;
import com.thesis.model.Faculty;
import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.model.abstracts.User;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IUserRepository;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Override
    public User retrieveUserByEntryVal(String entryVal) {
        Student student = retrieveByStudentNumber(entryVal);
        if(student != null) {
            return student;
        }
        return retrieveByEntryCode(entryVal);

    }

    private Student retrieveByStudentNumber(String studentNumber) {
        /*DetachedCriteria criteria = DetachedCriteria.forClass(Student.class)
                .add(Restrictions.eq("studentNumber", studentNumber));
        List<Student> studentsList = (List<Student>) getHibernateTemplate().findByCriteria(criteria);

        if(CollectionUtils.isEmpty(studentsList)) {
            return null;
        }
        return studentsList.get(0);*/
        return null;
    }

    private ThesisManager retrieveByEntryCode(String entryCode) {
        /*DetachedCriteria criteria = DetachedCriteria.forClass(ThesisManager.class)
                .add(Restrictions.eq("entryCode", entryCode));
        List<ThesisManager> thesisManagerList = (List<ThesisManager>) getHibernateTemplate().findByCriteria(criteria);

        if(CollectionUtils.isEmpty(thesisManagerList)) {
            return null;
        }
        return thesisManagerList.get(0);*/
        return null;
    }
}
