package com.thesis.repository;

import com.thesis.model.Department;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IDepartmentRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class DepartmentRepository extends AbstractRepository<Department> implements IDepartmentRepository {
}
