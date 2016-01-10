package com.thesis.service.interfaces;

import com.thesis.model.Season;
import com.thesis.model.ThesisManager;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ISeasonService extends IAbstractService<Season> {

    Season retrieveCurrentSeason(ThesisManager thesisManager);
}
