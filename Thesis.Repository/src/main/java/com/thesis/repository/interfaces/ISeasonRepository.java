package com.thesis.repository.interfaces;

import com.thesis.model.Season;
import com.thesis.model.ThesisManager;

import java.util.Date;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ISeasonRepository extends IAbstractRepository<Season> {

    Season retrieveCurrentSeason(ThesisManager thesisManager);

    boolean hasSeasonFor(Date startDate, Date endDate, ThesisManager thesisManager);
}
