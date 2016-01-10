package com.thesis.service;

import com.thesis.model.Season;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.service.interfaces.IThesisAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisAppealService extends AbstractService<ThesisAppeal> implements IThesisAppealService {

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    public ThesisAppealService(IThesisAppealRepository thesisAppealRepository) {
        super(thesisAppealRepository);
    }

    @Override
    public void save(ThesisAppeal thesisAppeal) {
        thesisAppeal.setAccepted(Boolean.FALSE);
        super.save(thesisAppeal);
    }

    @Override
    public boolean isQuotaHasExpired(ThesisManager thesisManager) {
        Season season = seasonService.retrieveCurrentSeason(thesisManager);
        int quota = season.getQuota();
        int numberOfAppeal = 0;

        List<ThesisTemplate> thesisTemplateList = season.getThesisTemplateList();
        for(ThesisTemplate thesisTemplate : thesisTemplateList) {
            List<ThesisAppeal> thesisAppealList = thesisTemplate.getThesisAppealList();
            for(ThesisAppeal thesisAppeal : thesisAppealList) {
                boolean accepted = thesisAppeal.getAccepted();
                if(accepted) {
                    numberOfAppeal++;
                }
            }
        }

        return quota <= numberOfAppeal;
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
