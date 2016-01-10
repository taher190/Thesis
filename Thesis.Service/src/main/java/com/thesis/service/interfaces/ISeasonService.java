package com.thesis.service.interfaces;

import com.thesis.model.Season;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ISeasonService extends IAbstractService<Season> {

    Season retrieveCurrentSeason();
}
