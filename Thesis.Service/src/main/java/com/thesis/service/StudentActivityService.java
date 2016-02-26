package com.thesis.service;

import com.thesis.model.StudentActivity;
import com.thesis.repository.interfaces.IStudentActivityRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IStudentActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class StudentActivityService extends AbstractService<StudentActivity>
        implements IStudentActivityService {

    @Autowired
    public StudentActivityService(IStudentActivityRepository studentActivityRepository){
        super(studentActivityRepository);
    }
}
