package com.thesis.repository;

import com.thesis.model.ThesisSuggestion;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisSuggestionRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisSuggestionRepository extends AbstractRepository<ThesisSuggestion> implements IThesisSuggestionRepository {
}
