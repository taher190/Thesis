package com.thesis.service;

import com.thesis.model.ThesisSuggestion;
import com.thesis.repository.interfaces.IThesisSuggestionRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IThesisSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisSuggestionService extends AbstractService<ThesisSuggestion> implements IThesisSuggestionService {

    @Autowired
    public ThesisSuggestionService(IThesisSuggestionRepository thesisSuggestionRepository) {
        super(thesisSuggestionRepository);
    }
}
