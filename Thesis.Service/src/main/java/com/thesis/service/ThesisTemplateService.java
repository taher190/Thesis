package com.thesis.service;

import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.interfaces.IThesisTemplateRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IThesisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisTemplateService extends AbstractService<ThesisTemplate> implements IThesisTemplateService {

    private IThesisTemplateRepository thesisTemplateRepository;

    @Autowired
    public ThesisTemplateService(IThesisTemplateRepository thesisTemplateRepository) {
        super(thesisTemplateRepository);
        this.thesisTemplateRepository = thesisTemplateRepository;
    }

    @Override
    public List<ThesisTemplate> retrieveByThesisManager(ThesisManager thesisManager) {
        return thesisTemplateRepository.retrieveByThesisManager(thesisManager);
    }
}
