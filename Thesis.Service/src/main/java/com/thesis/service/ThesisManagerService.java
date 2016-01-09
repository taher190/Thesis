package com.thesis.service;

import com.thesis.model.Department;
import com.thesis.model.ThesisManager;
import com.thesis.repository.interfaces.IThesisManagerRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IThesisManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisManagerService extends AbstractService<ThesisManager> implements IThesisManagerService {

    private IThesisManagerRepository thesisManagerRepository;

    @Autowired
    public ThesisManagerService(IThesisManagerRepository thesisManagerRepository) {
        super(thesisManagerRepository);
        this.thesisManagerRepository = thesisManagerRepository;
    }


    @Override
    public List<ThesisManager> retrieveByDepartment(Department department) {
        return thesisManagerRepository.retrieveByDepartment(department);
    }
}
