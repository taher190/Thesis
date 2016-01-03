package com.thesis.repository;

import com.thesis.model.Faculty;
import com.thesis.model.ThesisTemplate;
import com.thesis.model.Topic;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.ITopicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class TopicRepository extends AbstractRepository<Topic> implements ITopicRepository {

    @Override
    public List<Topic> retrieveByFaculty(Faculty faculty) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Topic> criteria = builder.createQuery( Topic.class );
        Root<Topic> topicRoot = criteria.from( Topic.class );
        criteria.select(topicRoot);
        criteria.where( builder.equal( topicRoot.get("faculty"), faculty) );
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
