package com.thesis.repository.interfaces;

import com.thesis.model.Student;
import com.thesis.model.ThesisAppeal;
import com.thesis.model.ThesisManager;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisAppealRepository extends IAbstractRepository<ThesisAppeal> {

    List<ThesisAppeal> retrieveByThesisManager(ThesisManager thesisManager);

    boolean checkOnlyOneThesisAppeal(Student student);
}
