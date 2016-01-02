package com.thesis.repository;

import com.thesis.model.ThesisAppeal;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisAppealRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisAppealRepository extends AbstractRepository<ThesisAppeal> implements IThesisAppealRepository {
}
