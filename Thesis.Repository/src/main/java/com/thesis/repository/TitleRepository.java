package com.thesis.repository;

import com.thesis.model.Title;
import com.thesis.repository.abstracts.AbstractRepository;
import com.thesis.repository.interfaces.ITitleRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Repository
public class TitleRepository extends AbstractRepository<Title> implements ITitleRepository {
}
