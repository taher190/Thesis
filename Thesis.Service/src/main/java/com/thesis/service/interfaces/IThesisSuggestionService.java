package com.thesis.service.interfaces;

import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisSuggestionService extends IAbstractService<ThesisSuggestion> {

    List<ThesisSuggestion> retrieveByThesisManager(ThesisManager thesisManager);
}
