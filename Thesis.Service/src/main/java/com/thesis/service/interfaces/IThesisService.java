package com.thesis.service.interfaces;

import com.thesis.model.*;
import com.thesis.model.abstracts.User;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisService extends IAbstractService<Thesis> {

    void createThesisWithActivity(ThesisAppeal thesisAppeal);

    void createThesisWithActivity(Season season, Student student, ThesisTemplate thesisTemplate);

    List<Thesis> retrieveCurrentThesis(Student student);

    List<Thesis> retrieveCurrentThesis(ThesisManager thesisManager);

    Double averageOfAllWeeks(Thesis thesis);
}
