package com.thesis.service;

import com.thesis.exception.SeasonNotFoundException;
import com.thesis.model.*;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.service.interfaces.IThesisAppealService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisAppealService extends AbstractService<ThesisAppeal> implements IThesisAppealService {

    private IThesisAppealRepository thesisAppealRepository;

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    public ThesisAppealService(IThesisAppealRepository thesisAppealRepository) {
        super(thesisAppealRepository);
        this.thesisAppealRepository = thesisAppealRepository;
    }

    @Override
    public void save(ThesisAppeal thesisAppeal) {
        super.save(thesisAppeal);
    }

    @Override
    public boolean isQuotaHasExpired(ThesisManager thesisManager) {
        Season season = seasonService.retrieveCurrentSeason(thesisManager);
        if(season == null) {
            throw new SeasonNotFoundException();
        }
        int numberOfAppeal = numberOfThesisAppealFor(thesisManager);
        int quota = season.getQuota();

        return quota <= numberOfAppeal;
    }

    @Override
    public List<ThesisAppeal> retrieveByThesisManager(ThesisManager thesisManager) {
        return thesisAppealRepository.retrieveByThesisManager(thesisManager);
    }

    @Override
    public boolean checkSingleThesisAppeal(Student student) {
        return thesisAppealRepository.checkSingleThesisAppeal(student);
    }

    @Override
    public int remainingLimitOfThesisManager(ThesisManager thesisManager) {
        Season season = seasonService.retrieveCurrentSeason(thesisManager);
        if(season == null) {
            throw new SeasonNotFoundException();
        }
        int numberOfAppeal = numberOfThesisAppealFor(thesisManager);
        int quota = season.getQuota();

        return quota - numberOfAppeal;
    }

    private int numberOfThesisAppealFor(ThesisManager thesisManager) {
        Season season = seasonService.retrieveCurrentSeason(thesisManager);
        if(season == null) {
            throw new SeasonNotFoundException();
        }
        int numberOfAppeal = 0;

        List<ThesisTemplate> thesisTemplateList = season.getThesisTemplateList();
        for(ThesisTemplate thesisTemplate : thesisTemplateList) {
            List<ThesisAppeal> thesisAppealList = thesisTemplate.getThesisAppealList();
            for(ThesisAppeal thesisAppeal : thesisAppealList) {
                boolean accepted = (boolean) ObjectUtils.defaultIfNull(
                        thesisAppeal.getAccepted(),
                        Boolean.FALSE);
                if(accepted) {
                    numberOfAppeal++;
                }
            }
        }
        return numberOfAppeal;
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
