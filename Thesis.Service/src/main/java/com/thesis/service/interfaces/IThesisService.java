package com.thesis.service.interfaces;

import com.thesis.model.Student;
import com.thesis.model.Thesis;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;
import com.thesis.model.abstracts.User;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisService extends IAbstractService<Thesis> {

    void createThesisWithActivity(ThesisAppeal thesisAppeal);

    List<Thesis> retrieveCurrentThesis(Student student);

    List<Thesis> retrieveCurrentThesis(ThesisManager thesisManager);
}
