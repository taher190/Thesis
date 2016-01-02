package com.thesis.service.interfaces;

import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisTemplateService extends IAbstractService<ThesisTemplate> {

    List<ThesisTemplate> retrieveByThesisManager(ThesisManager thesisManager);

    /**
     * Öğrencinin başvuru yapabileceği tez şablonlarını getir.
     * @param student
     * @return
     */
    List<ThesisTemplate> retrieveByStudent(Student student);
}
