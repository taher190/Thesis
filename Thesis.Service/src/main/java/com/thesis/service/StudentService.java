package com.thesis.service;

import com.thesis.model.Student;
import com.thesis.repository.interfaces.IStudentRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Service
public class StudentService extends AbstractService<Student> implements IStudentService {

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        super(studentRepository);
    }
}
