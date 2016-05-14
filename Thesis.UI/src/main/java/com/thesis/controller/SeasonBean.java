package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.controller.interfaces.ICRUDOperation;
import com.thesis.exception.SeasonException;
import com.thesis.model.Season;
import com.thesis.model.ThesisManager;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.statics.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class SeasonBean extends AbstractBean implements ICRUDOperation {

    private final Logger logger = LoggerFactory.getLogger(SeasonBean.class.getName());

    @ManagedProperty("#{seasonService}")
    private ISeasonService seasonService;

    private Season season;

    public SeasonBean() {
        setSeason(new Season());
    }

    @Override
    public void save() {
        try {
            ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
            season.setThesisManager(thesisManager);
            seasonService.save(season);
            logger.info("Season({}) has been saved!", season);
            showMessage("Tez dönemi başarıyla oluşturuldu!");
        } catch (SeasonException se) {
            showMessage(se.getMessage());
        }
    }

    private boolean checkConflictSeason(ThesisManager thesisManager) {
        return seasonService.hasSeasonFor(season.getStartDate(), season.getEndDate(), thesisManager);
    }

    @Override
    public void update() {
        seasonService.update(season);
        logger.info("Season({}) has been updated!", season);
        showMessage("Tez dönemi başarıyla güncellendi!");
    }

    @Override
    public void delete() {
        seasonService.deleteById(season.getId());
        logger.info("Season({}) has been deleted!", season);
        showMessage("Tez dönemi başarıyla silindi!");
    }

    public void loadSeason() {
        ThesisManager thesisManager = (ThesisManager) getLoggedInUser();
        setSeason(seasonService.retrieveCurrentSeason(thesisManager));
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
