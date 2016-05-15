package com.thesis.repository.interfaces;

import com.thesis.model.Student;
import com.thesis.model.Thesis;
import com.thesis.model.ThesisManager;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisRepository extends IAbstractRepository<Thesis> {

    List<Thesis> retrieveCurrentThesis(Student student);

    List<Thesis> retrieveCurrentThesis(ThesisManager thesisManager);

    Double averageOfAllWeeks(Thesis thesis);
}
