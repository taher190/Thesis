package com.thesis.service.interfaces;

import com.thesis.model.Season;
import com.thesis.model.ThesisManager;

import java.util.Date;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ISeasonService extends IAbstractService<Season> {

    Season retrieveCurrentSeason(ThesisManager thesisManager);

    boolean hasSeasonFor(Date startDate, Date endDate, ThesisManager thesisManager);
}
