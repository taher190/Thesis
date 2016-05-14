package com.thesis.service;

import com.thesis.exception.SeasonException;
import com.thesis.model.Season;
import com.thesis.model.ThesisManager;
import com.thesis.repository.interfaces.IAbstractRepository;
import com.thesis.repository.interfaces.ISeasonRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.statics.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

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
        if(hasSeasonFor(season.getStartDate(), season.getEndDate(), season.getThesisManager())) {
            throw new SeasonException(Messages.CANNOT_CREATE_CONFLICT_THESIS_SEASON);
        }
        super.save(season);
    }

    @Override
    public boolean hasSeasonFor(Date startDate, Date endDate, ThesisManager thesisManager) {
        return seasonRepository.hasSeasonFor(startDate, endDate, thesisManager);
    }
}
