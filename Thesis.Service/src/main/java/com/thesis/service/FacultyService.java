package com.thesis.service;

import com.thesis.model.Faculty;
import com.thesis.repository.interfaces.IFacultyRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Service
public class FacultyService extends AbstractService<Faculty> implements IFacultyService {

    @Autowired
    public FacultyService(IFacultyRepository facultyRepository) {
        super(facultyRepository);
    }
}
