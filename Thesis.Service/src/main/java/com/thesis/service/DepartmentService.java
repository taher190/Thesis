package com.thesis.service;

import com.thesis.model.Department;
import com.thesis.repository.interfaces.IDepartmentRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class DepartmentService extends AbstractService<Department> implements IDepartmentService {

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository) {
        super(departmentRepository);
    }
}
