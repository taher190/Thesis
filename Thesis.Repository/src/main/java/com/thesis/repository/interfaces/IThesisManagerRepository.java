package com.thesis.repository.interfaces;

import com.thesis.model.Department;
import com.thesis.model.ThesisManager;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisManagerRepository extends IAbstractRepository<ThesisManager> {

    List<ThesisManager> retrieveByDepartment(Department department);
}
