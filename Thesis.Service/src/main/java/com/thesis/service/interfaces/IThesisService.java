package com.thesis.service.interfaces;

import com.thesis.model.Thesis;
import com.thesis.model.ThesisAppeal;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisService extends IAbstractService<Thesis> {

    void createThesisWithActivity(ThesisAppeal thesisAppeal);
}
