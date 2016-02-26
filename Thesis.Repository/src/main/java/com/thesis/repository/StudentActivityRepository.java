package com.thesis.repository;

import com.thesis.model.StudentActivity;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IStudentActivityRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class StudentActivityRepository extends AbstractRepository<StudentActivity>
        implements IStudentActivityRepository {
}
