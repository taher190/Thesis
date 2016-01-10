package com.thesis.service.interfaces;

import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisAppealService extends IAbstractService<ThesisAppeal> {

    /**
    *
    * Yapılan başvuru sayısının, tez danışmanının kotasını aştığını veya aşmadığını ifade eder.
    * @param thesisManager
    * @return
    *
    * */
    boolean isQuotaHasExpired(ThesisManager thesisManager);
}
