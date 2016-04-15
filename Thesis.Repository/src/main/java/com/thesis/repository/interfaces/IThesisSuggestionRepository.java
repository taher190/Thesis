package com.thesis.repository.interfaces;

import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisSuggestionRepository extends IAbstractRepository<ThesisSuggestion> {

    List<ThesisSuggestion> retrieveByThesisManager(ThesisManager thesisManager);
}
