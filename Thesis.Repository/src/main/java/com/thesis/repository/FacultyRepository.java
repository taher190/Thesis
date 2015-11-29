package com.thesis.repository;

import com.thesis.model.Faculty;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IFacultyRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Repository
public class FacultyRepository extends AbstractRepository<Faculty> implements IFacultyRepository {
}
