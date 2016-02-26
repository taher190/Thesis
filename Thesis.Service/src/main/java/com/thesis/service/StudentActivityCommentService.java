package com.thesis.service;

import com.thesis.model.StudentActivityComment;
import com.thesis.repository.interfaces.IStudentActivityCommentRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IStudentActivityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class StudentActivityCommentService extends AbstractService<StudentActivityComment>
        implements IStudentActivityCommentService {

    @Autowired
    public StudentActivityCommentService(IStudentActivityCommentRepository studentActivityCommentRepository) {
        super(studentActivityCommentRepository);
    }
}
