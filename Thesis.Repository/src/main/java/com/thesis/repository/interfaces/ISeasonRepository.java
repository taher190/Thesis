package com.thesis.repository.interfaces;

import com.thesis.model.Season;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ISeasonRepository extends IAbstractRepository<Season> {

    Season retrieveCurrentSeason();
}
