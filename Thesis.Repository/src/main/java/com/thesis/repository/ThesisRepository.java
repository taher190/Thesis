package com.thesis.repository;

import com.thesis.model.Thesis;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.IThesisRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class ThesisRepository extends AbstractRepository<Thesis> implements IThesisRepository {
}
