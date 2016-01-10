package com.thesis.service;

import com.thesis.model.Season;
import com.thesis.repository.interfaces.IAbstractRepository;
import com.thesis.repository.interfaces.ISeasonRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class SeasonService extends AbstractService<Season> implements ISeasonService {

    private ISeasonRepository seasonRepository;

    @Autowired
    public SeasonService(ISeasonRepository seasonRepository) {
        super(seasonRepository);
        this.seasonRepository = seasonRepository;

    }

    @Override
    public Season retrieveCurrentSeason() {
        return seasonRepository.retrieveCurrentSeason();
    }
}
