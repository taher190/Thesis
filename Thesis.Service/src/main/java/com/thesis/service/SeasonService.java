package com.thesis.service;

import com.thesis.model.Season;
import com.thesis.model.ThesisManager;
import com.thesis.repository.interfaces.IAbstractRepository;
import com.thesis.repository.interfaces.ISeasonRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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
    public Season retrieveCurrentSeason(ThesisManager thesisManager) {
        return seasonRepository.retrieveCurrentSeason(thesisManager);
    }

    @Override
    public void save(Season season) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(season.getStartDate());
        calendar.add(Calendar.WEEK_OF_YEAR, season.getNumberOfWeek());
        season.setEndDate(calendar.getTime());
        super.save(season);
    }
}
