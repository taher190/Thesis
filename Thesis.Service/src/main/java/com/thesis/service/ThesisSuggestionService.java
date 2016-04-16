package com.thesis.service;

import com.thesis.model.Season;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisSuggestion;
import com.thesis.repository.interfaces.IThesisSuggestionRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.service.interfaces.IThesisSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisSuggestionService extends AbstractService<ThesisSuggestion> implements IThesisSuggestionService {

    private IThesisSuggestionRepository thesisSuggestionRepository;

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    public ThesisSuggestionService(IThesisSuggestionRepository thesisSuggestionRepository) {
        super(thesisSuggestionRepository);
        this.thesisSuggestionRepository = thesisSuggestionRepository;
    }

    @Override
    public void save(ThesisSuggestion thesisSuggestion) {
        Season season = seasonService.retrieveCurrentSeason(thesisSuggestion.getThesisManager());
        thesisSuggestion.setSeason(season);
        super.save(thesisSuggestion);
    }


    @Override
    public List<ThesisSuggestion> retrieveByThesisManager(ThesisManager thesisManager) {
        return thesisSuggestionRepository.retrieveByThesisManager(thesisManager);
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
