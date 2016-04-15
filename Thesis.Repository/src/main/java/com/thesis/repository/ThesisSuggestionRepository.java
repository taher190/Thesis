package com.thesis.repository;

import com.thesis.model.Faculty;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisSuggestionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisSuggestionRepository extends AbstractRepository<ThesisSuggestion> implements IThesisSuggestionRepository {

    @Override
    public List<ThesisSuggestion> retrieveByThesisManager(ThesisManager thesisManager) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ThesisSuggestion> criteria = builder.createQuery( ThesisSuggestion.class );
        Root<ThesisSuggestion> thesisSuggestionRoot = criteria.from( ThesisSuggestion.class );
        criteria.select(thesisSuggestionRoot);
        criteria.where(builder.equal(thesisSuggestionRoot.get("thesisManager"), thesisManager));
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
