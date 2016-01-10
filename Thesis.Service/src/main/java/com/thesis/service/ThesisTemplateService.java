package com.thesis.service;

import com.thesis.model.Season;
import com.thesis.model.Student;
import com.thesis.model.ThesisManager;
import com.thesis.model.ThesisTemplate;
import com.thesis.repository.interfaces.IThesisTemplateRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ISeasonService;
import com.thesis.service.interfaces.IThesisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisTemplateService extends AbstractService<ThesisTemplate> implements IThesisTemplateService {

    private IThesisTemplateRepository thesisTemplateRepository;

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    public ThesisTemplateService(IThesisTemplateRepository thesisTemplateRepository) {
        super(thesisTemplateRepository);
        this.thesisTemplateRepository = thesisTemplateRepository;
    }

    @Override
    public void save(ThesisTemplate thesisTemplate) {
        thesisTemplate.setActive(true);
        Season season = seasonService.retrieveCurrentSeason(thesisTemplate.getThesisManager());
        thesisTemplate.setSeason(season);
        super.save(thesisTemplate);
    }

    @Override
    public List<ThesisTemplate> retrieveByStudent(Student student) {
        return thesisTemplateRepository.retrieveByStudent(student);
    }

    @Override
    public List<ThesisTemplate> retrieveByThesisManager(ThesisManager thesisManager) {
        return thesisTemplateRepository.retrieveByThesisManager(thesisManager);
    }

    public ISeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
}
