package com.thesis.repository;

import com.thesis.model.Student;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IStudentRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class StudentRepository extends AbstractRepository<Student> implements IStudentRepository {
}
