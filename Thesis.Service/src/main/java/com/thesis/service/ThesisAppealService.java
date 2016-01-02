package com.thesis.service;

import com.thesis.model.ThesisAppeal;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IThesisAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisAppealService extends AbstractService<ThesisAppeal> implements IThesisAppealService {

    @Autowired
    public ThesisAppealService(IThesisAppealRepository thesisAppealRepository) {
        super(thesisAppealRepository);
    }
}
