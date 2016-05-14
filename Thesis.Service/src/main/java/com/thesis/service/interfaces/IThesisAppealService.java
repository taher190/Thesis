package com.thesis.service.interfaces;

import com.thesis.model.Student;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;

import java.util.List;

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

    List<ThesisAppeal> retrieveByThesisManager(ThesisManager thesisManager);

    boolean checkOnlyOneThesisAppeal(Student student);

    int remainingLimitOfThesisManager(ThesisManager thesisManager);
}
