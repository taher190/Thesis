package com.thesis.repository;

import com.thesis.model.StudentActivityComment;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IStudentActivityCommentRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class StudentActivityCommentRepository extends AbstractRepository<StudentActivityComment>
        implements IStudentActivityCommentRepository {
}
