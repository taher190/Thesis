package com.thesis.repository.interfaces;

import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisTemplateRepository extends IAbstractRepository<ThesisTemplate> {

    List<ThesisTemplate> retrieveByThesisManager(ThesisManager thesisManager);
}
