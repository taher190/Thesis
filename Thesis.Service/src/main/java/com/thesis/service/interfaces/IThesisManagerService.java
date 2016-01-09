package com.thesis.service.interfaces;

import com.thesis.model.Department;
import com.thesis.model.ThesisManager;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisManagerService extends IAbstractService<ThesisManager> {

    List<ThesisManager> retrieveByDepartment(Department department);
}
